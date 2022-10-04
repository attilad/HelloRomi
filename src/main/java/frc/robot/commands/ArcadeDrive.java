package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RomiDrivetrain;

public class ArcadeDrive extends CommandBase {
    private final RomiDrivetrain m_drivetrain;
    private final Supplier<Double> m_xaxisSpeedSupplier;
    private final Supplier<Double> m_zaxisRotateSupplier;

    public ArcadeDrive(
        RomiDrivetrain drivetrain,
        Supplier<Double> xaxisSpeedSupplier,
        Supplier<Double> zaxisSpeedSupplier
    ) {
        m_drivetrain = drivetrain;
        m_xaxisSpeedSupplier = xaxisSpeedSupplier;
        m_zaxisRotateSupplier = zaxisSpeedSupplier;
    }

    @Override
    public void initialize() {}

    @Override
    public void end(boolean interrupted) {}

    @Override
    public void execute() {
        m_drivetrain.arcadeDrive(m_xaxisSpeedSupplier.get(), m_zaxisRotateSupplier.get());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    
}
