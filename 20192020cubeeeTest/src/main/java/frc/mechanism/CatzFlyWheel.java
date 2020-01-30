package frc.mechanism;
   
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.*;  
import edu.wpi.first.wpilibj.XboxController;   

public class CatzFlyWheel
{
    WPI_TalonSRX shooterRT;
    WPI_TalonSRX shooterLT;

    Spark jostlerRT;
    Spark jostlerLT;

    Spark conveyer;

    public final int SHOOTER_RT_PORT_NUM = 3;
    public final int SHOOTER_LT_PORT_NUM = 2;
    public final int CONVEYER_PORT_NUM = 3;

    public final int JOSTLER_RT_PORT_NUM = 4;
    public final int JOSTLER_LT_PORT_NUM = 5;

    public CatzFlyWheel ()
    {
        shooterRT = new WPI_TalonSRX(SHOOTER_RT_PORT_NUM);
        shooterLT = new WPI_TalonSRX(SHOOTER_LT_PORT_NUM);

        conveyer = new Spark(CONVEYER_PORT_NUM);

        jostlerRT = new Spark(JOSTLER_RT_PORT_NUM);
        jostlerLT = new Spark(JOSTLER_LT_PORT_NUM);

    }

    public void shoot (double power)
    {
        shooterLT.set(-power);
        shooterRT.set(power);
    }
    
    public void ballConveyer (double power)
    {
        conveyer.set(power);
    }

    public void jostle (double power)
    {
        jostlerLT.set(power);
        jostlerRT.set(-power);
    }

}


