package frc.robot;

import edu.wpi.first.hal.util.UncleanStatusException;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Timer;

import com.ctre.phoenix.motorcontrol.can.*;

import frc.Vision.SensorObjContainer;
import frc.Vision.SensorObject;
import frc.Vision.UDPServerThread;




/*
*  Author : Derek Duenas
*  Last Revised : 2-9-2018 AL
*  touchup
*  Methods : setModeArcadeDriveRacing, setModeArcadeDriveFlash
*  Functionality : sets the drive mode to racing or flash
*/

public class CatzDrive
{

	public static SpeedControllerGroup leftMotors;
	public static SpeedControllerGroup rightMotors;

	public static WPI_TalonSRX fRight;
	public static WPI_TalonSRX rRight;
	public static WPI_TalonSRX fLeft;
	public static WPI_TalonSRX rLeft;
	
	public static Encoder leftDTEncoder;

	private DifferentialDrive drive;

	private Thread visionHeadingThread;
	private Thread visionDistanceThread;

	public static volatile double targetAngle;
	public static volatile double targetDistance;

	public SensorObject vo;

	private double heading, distance;
	private int targetLock, targetNum;
	private boolean visionValidity;
	

	public CatzDrive()
	{

		fRight = new WPI_TalonSRX(4); 
		rRight = new WPI_TalonSRX(5);
		fLeft  = new WPI_TalonSRX(0);
		rLeft  = new WPI_TalonSRX(1);

		leftMotors  = new SpeedControllerGroup(fLeft, rLeft);
		rightMotors = new SpeedControllerGroup(fRight, rRight);

		drive = new DifferentialDrive(leftMotors, rightMotors);
		drive.setSafetyEnabled(false);
		//printOutDebugData("Successfully instantiated CatzDrive");

		try
		{

		leftDTEncoder = new Encoder(6, 7, false, Encoder.EncodingType.k4X);
		leftDTEncoder.setDistancePerPulse(0.0508);

		}
		catch(UncleanStatusException e)
		{

			System.out.println("uncleanStatusException");

		}
		catch(NullPointerException e)
		{
			System.out.println("NullPointerException");
		}

		
	}

	public double getDriveTrainEncoder()
	{
		double distance = 0.0;
		try 
		{
			distance =leftDTEncoder.get();
		} 
		catch (NullPointerException e) 
		{
			distance = 0.0;
		}

		return	distance;
	} 

	public double getDriveTrainEncoderDistance()
	{
		return leftDTEncoder.getDistance();
	}
	
	public void setModeArcadeDriveRacing(XboxController control){
		drive.arcadeDrive(control.getRawAxis(3)-control.getRawAxis(2), control.getRawAxis(4));
	}
	
	public void setModeArcadeDriveFlash(XboxController control){
		drive.arcadeDrive(control.getRawAxis(1), control.getRawAxis(4));
	}
	public void setModeReverseArcadeDriveFlash(XboxController control){
		drive.arcadeDrive(-control.getRawAxis(1), control.getRawAxis(4));
	}
	
	public void tankDrive(double lPower, double rPower){
		drive.tankDrive(lPower, rPower);
	}
	
	public void arcadeDrive(double xSpeed, double zRotation) {
		drive.arcadeDrive(xSpeed, zRotation, true);
	}

	public void arcadeDrive(double xSpeed, double zRotation, boolean squareInputs)
	{
		drive.arcadeDrive(xSpeed, zRotation, squareInputs);
	}

	public void stop()
	{
		drive.stopMotor();
	}

	public void visionHeadingPID()
	{

		visionHeadingThread = new Thread (() ->
		{

			final double VISION_THREAD_WAITING_TIME = 0.005;

			final double kP = 0.005;//0.007
            final double kD = 0.0005; 
            final double kI = 0.00001;
            final double kA = 0.0022;//0.0077;
            final double kF = 0.0;//-0.05;

            double power;            

            Timer visionTimer = new Timer();
            visionTimer.start();

            double previousError = 0;
            double currentError; 
            double deltaError = 0; 

            double previousDerivative = 0;
            double currentDerivative;    // in case you want to filter derivative
            double filteredDerivative;
            
            double previousTime = 0;
            
            double deltaTime;
            
            double currentTime;
            double currentAngle;

            double integral = 0;

            double kAPow;
            double kPPow;
            double kDPow;
            double kIPow;

			while(true)
            {
                if(targetAngle == 999.9 )
                {
                    Timer.delay(0.005);
                }
                else
                {
                    //SmartDashboard.putBoolean("pivot pid state", runPivotPID);
                    currentTime  = visionTimer.get();
                    currentAngle = vo.getHeading();

                    currentError = targetAngle - currentAngle;
                    
                    /*if(Math.abs(currentError-previousError) < 1.0)
                    {
                       if((armTimer.get() - currentTime) > 0.1)
                       {
                            runPivotPID = false;
                            turnPivot(0.0);
                            setPivotTargetAngle(CatzConstants.INVALID_ANGLE);
                            Thread.currentThread().interrupt();
                       }    
                          
                    }*/

                    //if(runPivotPID == true)
                    //{
                        deltaError = currentError - previousError;
                        deltaTime  = currentTime  - previousTime;

                        integral += deltaTime * currentError;

                        currentDerivative = (deltaError / deltaTime);
                        filteredDerivative = (0.7 * currentDerivative) + (0.3 * previousDerivative);

                        kAPow = 0; //kA * ((getArmExtensionDistance() + 13) * Math.cos(Math.toRadians(currentAngle - 45)));
                        kPPow = kP * currentError;
                        kDPow = kD * filteredDerivative; //currentDerivative
                        kIPow = kI * integral;

                        power = kPPow + kIPow + kDPow + kAPow;//ka compensates for angle of arm
                                //arm extension distance + 13 is the distance from pivot to wrist
                                // + kF; //+ (kI * integral)

                        //turnPivot(-power);

                        drive.arcadeDrive(0, -power);

                    
                        previousError = currentError;
                        previousTime = currentTime;

                        previousDerivative = currentDerivative;
                    
                        Timer.delay(VISION_THREAD_WAITING_TIME);
                    //}
                }
            }
        });
        visionHeadingThread.start();
	}

	public void visionDistancePID()
	{
	
		visionDistanceThread = new Thread (() ->
		{

			final double VISION_THREAD_WAITING_TIME = 0.005;

			final double kP = 0.005;//0.007
            final double kD = 0.0005; 
            final double kI = 0.00001;
            final double kA = 0.0022;//0.0077;
            final double kF = 0.0;//-0.05;

            double power;            

            Timer visionTimer = new Timer();
            visionTimer.start();

            double previousError = 0;
            double currentError; 
            double deltaError = 0; 

            double previousDerivative = 0;
            double currentDerivative;    // in case you want to filter derivative
            double filteredDerivative;
            
            double previousTime = 0;
            
            double deltaTime;
            
            double currentTime;
            double currentAngle;

            double integral = 0;

            double kAPow;
            double kPPow;
            double kDPow;
            double kIPow;

			while(true)
            {
                if(targetDistance == 999.9 )
                {
                    Timer.delay(0.005);
                }
                else
                {
                    //SmartDashboard.putBoolean("pivot pid state", runPivotPID);
                    currentTime  = visionTimer.get();
                    currentAngle = vo.getDistance();

                    currentError = targetAngle - currentAngle;
                    
                    /*if(Math.abs(currentError-previousError) < 1.0)
                    {
                       if((armTimer.get() - currentTime) > 0.1)
                       {
                            runPivotPID = false;
                            turnPivot(0.0);
                            setPivotTargetAngle(CatzConstants.INVALID_ANGLE);
                            Thread.currentThread().interrupt();
                       }    
                          
                    }*/

                    //if(runPivotPID == true)
                    //{
                        deltaError = currentError - previousError;
                        deltaTime  = currentTime  - previousTime;

                        integral += deltaTime * currentError;

                        currentDerivative = (deltaError / deltaTime);
                        filteredDerivative = (0.7 * currentDerivative) + (0.3 * previousDerivative);

                        kAPow = 0; //kA * ((getArmExtensionDistance() + 13) * Math.cos(Math.toRadians(currentAngle - 45)));
                        kPPow = kP * currentError;
                        kDPow = kD * filteredDerivative; //currentDerivative
                        kIPow = kI * integral;

                        power = kPPow + kIPow + kDPow + kAPow;//ka compensates for angle of arm
                                //arm extension distance + 13 is the distance from pivot to wrist
                                // + kF; //+ (kI * integral)

                        //turnPivot(-power);

                      //  drive.arcadeDrive(-power, visionHeadingPID());

                    
                        previousError = currentError;
                        previousTime = currentTime;

                        previousDerivative = currentDerivative;
                    
                        Timer.delay(VISION_THREAD_WAITING_TIME);
                    //}
                }
            }
        });
        visionHeadingThread.start();
	}

}
