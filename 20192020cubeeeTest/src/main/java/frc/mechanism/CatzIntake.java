package frc.mechanism;

import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.*;  
import edu.wpi.first.wpilibj.XboxController;   

public class CatzIntake
{
Spark intake;
public int intakePort = 2;
    public CatzIntake()
    {
        intake = new Spark(intakePort);
    }

    public void intake (double power)
    {
        intake.set(power);
    }
}