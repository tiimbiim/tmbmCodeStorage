package frc.mechanism;
  
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.*;  
import edu.wpi.first.wpilibj.XboxController;  
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class CatzDrive
{
    public static SpeedControllerGroup leftMotors;
    public static SpeedControllerGroup rightMotors;

    public static WPI_TalonSRX drvTrainMtrCtrlLTFrnt;
    public static WPI_TalonSRX drvTrainMtrCtrlLTBack;
    public static WPI_TalonSRX drvTrainMtrCtrlRTFrnt;
    public static WPI_TalonSRX drvTrainMtrCtrlRTBack;

    private final int DRVTRAIN_RT_FRNT_MC_CAN_ID = 4;
    private final int DRVTRAIN_RT_BACK_MC_CAN_ID = 5;
    private final int DRVTRAIN_LT_FRNT_MC_CAN_ID = 0;
    private final int DRVTRAIN_LT_BACK_MC_CAN_ID = 1;
    private DifferentialDrive drive;

    public CatzDrive ()
    {
        drvTrainMtrCtrlLTBack= new WPI_TalonSRX (DRVTRAIN_LT_BACK_MC_CAN_ID);
        drvTrainMtrCtrlLTFrnt= new WPI_TalonSRX (DRVTRAIN_LT_FRNT_MC_CAN_ID);
        drvTrainMtrCtrlRTBack= new WPI_TalonSRX (DRVTRAIN_RT_BACK_MC_CAN_ID);
        drvTrainMtrCtrlRTFrnt= new WPI_TalonSRX (DRVTRAIN_RT_FRNT_MC_CAN_ID);

        leftMotors = new SpeedControllerGroup (drvTrainMtrCtrlLTFrnt, drvTrainMtrCtrlLTBack);
        rightMotors = new SpeedControllerGroup (drvTrainMtrCtrlRTFrnt, drvTrainMtrCtrlRTBack);

        drive = new DifferentialDrive (leftMotors, rightMotors);

}

public void arcadeDrive(double xSpeed, double zRotation)
{
    drive.arcadeDrive(xSpeed, zRotation, true);
}
}