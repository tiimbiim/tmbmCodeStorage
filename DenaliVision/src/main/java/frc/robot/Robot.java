/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                             s  */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.io.IOException;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.Vision.SensorObjContainer;
import frc.Vision.SensorObject;
import frc.Vision.UDPServerThread;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot
{
	public static AHRS navx;
	public UDPServerThread server;

	public SensorObject vo;

	private double heading, distance;
	private int targetLock, targetNum;
	private boolean visionValidity;

	public static CatzDrive driveTrain;

	public static double previousRotation;
	public static double rotation;
	public static boolean inDriveTrack = false;
	public static boolean completedDT = false;
	public static double driveTrackDistance;
	public static double turnBack;

	XboxController drv = new XboxController(0);

	double currentError = 0;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit()
	{

		server = new UDPServerThread();
		driveTrain = new CatzDrive();

		navx = new AHRS(SerialPort.Port.kMXP);

		// starting UDP Server
		server.start();

		navx.reset();

		drv.setRumble(RumbleType.kLeftRumble, 0);
		drv.setRumble(RumbleType.kRightRumble, 0);

	}

	/**
	 * This function is called every robot packet, no matter the mode. Use this for
	 * items like diagnostics that you want ran during disabled, autonomous,
	 * teleoperated and test.
	 *
	 * <p>
	 * This runs after the mode specific periodic functions, but before LiveWindow
	 * and SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic()
	{

		vo = SensorObjContainer.get("vis");
		distance = 0;
		heading = 0;

		visionValidity = false;

		if (vo != null)
		{
			distance = vo.getDistance();
			heading = vo.getHeading();

			visionValidity = vo.isValid();
		}

		if (drv.getAButton() == true)
		{
			driveTrain.leftDTEncoder.reset();
		}

		SmartDashboard.putNumber("heading plot", heading);
		SmartDashboard.putNumber("distance plot", distance);

		try
		{
			SmartDashboard.putNumber("Distance", distance);
			SmartDashboard.putNumber("Heading", heading);

			SmartDashboard.putNumber("encoder dist", driveTrain.getDriveTrainEncoderDistance());
			SmartDashboard.putNumber("encoder counts", driveTrain.getDriveTrainEncoder());
			SmartDashboard.putNumber("navx angle", navx.getAngle());
		}
		catch (NullPointerException e)
		{

		}
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString line to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the SendableChooser
	 * make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit()
	{
		drv.setRumble(RumbleType.kLeftRumble, 0);
		drv.setRumble(RumbleType.kRightRumble, 0);

		completedDT = false;
	}

	public void driveTrack(double distance, double correctedHeading)
	{

		double theta = 0;

		if (inDriveTrack)
		{
			double encoderDist = driveTrain.getDriveTrainEncoderDistance();
			if (encoderDist >= (driveTrackDistance-17))
			{

				System.out.println("Drive distance met " + encoderDist + " " + driveTrackDistance + " " + turnBack);
				driveTrain.tankDrive(0, 0);

				CatzTurn.PIDturn(turnBack, 0.4);

				inDriveTrack = false;
				completedDT = true;
			}
		}
		else
		{
			if (!completedDT)
			{
				if (distance > 60 && Math.abs(correctedHeading) > 5)
				{
					inDriveTrack = true;
					if (heading > 0)
					{
						theta = 0.9 * (90 - heading);
						turnBack = -(theta + heading);
					}
					else
					{
						theta = 0.9 * (-90 - heading);
						turnBack = -(theta - heading);
					}
					// Drive Distance seemed to long, take 80% as a
					double thetaRadian = Math.toRadians(theta);
					double cosTheta = Math.abs(Math.cos(thetaRadian));
					driveTrackDistance = Math.abs(1.0 * distance * cosTheta);
					System.out.println(
							"theta " + theta + "(" + thetaRadian + ")" + "  turnBack " + turnBack + "  Drive Distance "
									+ driveTrackDistance + "  Distance " + distance
					);
					CatzTurn.PIDturn(theta, 0.4);

					driveTrain.leftDTEncoder.reset();

					System.out.println("drivetrain encoder " + driveTrain.getDriveTrainEncoderDistance());
					System.out.println("end of turn / beginning drive");

					driveTrain.tankDrive(0.5, 0.5);
					System.out.println("Start of Drive");
				}
			}
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic()
	{
		double motorPower = 0.3;
		rotation = 0.0;

		/***************************************************************************** */
		/* Compute heading offset */

		double cameraOffset = 14; // 12 inches to the right
		// Compute x from raspberryPi Heading and distance
		// x = Distance * sin(heading)
		double x = distance * Math.sin(Math.toRadians(heading));

		// Correct x (xHat) by known offset
		double xHat = x + cameraOffset;

		// Compute corrected heading (phiHat) as:
		// sin ( phiHat )= xHat / Distance
		// --> phiHat = arcSin (xHat/Distance)
		double phiHat = xHat / distance;
		if (phiHat > 0.3)
		{
			phiHat = 0.3;
		}
		if (phiHat < -0.3)
		{
			phiHat = -0.3;
		}

		double correctedHeading = Math.toDegrees(Math.asin(phiHat));

		driveTrack(distance, correctedHeading);

		if(vo.isValid()) 
		{
			if (!inDriveTrack)
			{
				if (correctedHeading > 1.5)
				{
					rotation = 0.3;
				}
				else if (correctedHeading < -1.5)
				{
					rotation = -0.3;
				}
				else
				{
					rotation = 0;
				}

				if (distance < 45)
				{
					motorPower = 0;
					rotation = 0;
				}

				System.out.println("Distance " + distance + " X: " + x + ", " + xHat + "|");
				System.out.println("Drive: " + motorPower + ", " + rotation + "|");
				System.out.println("Heading: " + heading + ", " + correctedHeading + "|");
				
				SmartDashboard.putNumber("Rotation", rotation);

				driveTrain.arcadeDrive(motorPower, rotation, false);

			} // End if not in driveTrack

			else
			{
				SmartDashboard.putNumber("corrected heading", correctedHeading);
				SmartDashboard.putNumber("heading 2 ", heading);
			}
		}
		else
		{
			System.out.println("vision is invalid");
		}

	}

	@Override
	public void teleopInit()
	{
		System.out.println("beginning teleop init");
	}

	/*
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic()
	{
		/*
		 * double cameraOffset = 12;
		 * 
		 * double headingOffsetMath =
		 * (Math.sin(Math.toRadians(heading))-(cameraOffset/distance));
		 * 
		 * if(headingOffsetMath > 0.4) { headingOffsetMath = 20; } if(headingOffsetMath
		 * < -0.4) { headingOffsetMath = -20; }
		 * 
		 * double headingOffset = Math.asin(headingOffsetMath); double correctedHeading
		 * = heading - Math.toDegrees(headingOffset);
		 * 
		 * 
		 * double motorPower = 0.0; double rotation = 0.0;
		 * 
		 */
			driveTrain.arcadeDrive(-drv.getY(Hand.kLeft), drv.getX(Hand.kRight));
		if (visionValidity && drv.getTriggerAxis(Hand.kRight) >= 0.05 && drv.getTriggerAxis(Hand.kRight) < 0.75)
		{
			drv.setRumble(RumbleType.kLeftRumble, 0.5);
			drv.setRumble(RumbleType.kRightRumble, 0.5);
		}
		else if (visionValidity && drv.getTriggerAxis(Hand.kRight) == 1)
		{
			drv.setRumble(RumbleType.kLeftRumble, 0.75);
			drv.setRumble(RumbleType.kRightRumble, 0.75);
			/*
			 * if(distance >= 50) { motorPower = 0.35; if(correctedHeading > 2) { rotation =
			 * 0.3; } else if(correctedHeading < -2) { rotation = -0.3; } }
			 * 
			 * if(distance <= 35) { motorPower = 0; rotation = 0; }
			 * 
			 * } else { drv.setRumble(RumbleType.kLeftRumble, 0);
			 * drv.setRumble(RumbleType.kRightRumble, 0); }
			 * 
			 * double totalPower = motorPower + -drv.getY(Hand.kLeft); double totalRotation
			 * = rotation + drv.getX(Hand.kRight);
			 * 
			 * if(totalPower > 1) { totalPower = 1; } if(totalPower < -1) { totalPower = -1;
			 * }
			 * 
			 * if(totalRotation > 1) { totalRotation = 1; } if(totalRotation < -1) {
			 * totalRotation = -1; }
			 * 
			 * 
			 * if (drv.getPOV() == 270) { try {
			 * 
			 * UDPServerThread.targetRight();
			 * 
			 * } catch (IOException e) {
			 * 
			 * 
			 * e.printStackTrace(); }
			 */
		}
		/*
		 * SmartDashboard.putNumber("total power", totalPower);
		 * SmartDashboard.putNumber("total rotation", totalRotation);
		 * 
		 * SmartDashboard.putNumber("corrected heading", correctedHeading);
		 * 
		 * SmartDashboard.putNumber("motorPower", motorPower);
		 * 
		 * SmartDashboard.putNumber("xbox left stick Y", drv.getY(Hand.kLeft));
		 * SmartDashboard.putNumber("xbox right stick X", drv.getX(Hand.kRight));
		 * driveTrain.arcadeDrive(totalPower, totalRotation, false);
		 */
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic()
	{

	}

	@Override
	public void disabledPeriodic()
	{
		drv.setRumble(RumbleType.kLeftRumble, 0);
		drv.setRumble(RumbleType.kRightRumble, 0);
	}
}
