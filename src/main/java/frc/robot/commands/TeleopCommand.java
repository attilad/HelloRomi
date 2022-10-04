package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.RomiDrivetrain;

public class TeleopCommand extends ParallelCommandGroup {

    public TeleopCommand(RomiDrivetrain drivetrain, Joystick joystick) {
        Supplier<Double> xaxisSpeedSupplier = () -> joystick.getRawAxis(1);
        Supplier<Double> zaxisRotateSuppplier =  () -> -joystick.getRawAxis(2);
    }
    
}
