package frc.robot.subsystems.shooter.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;

public class Shoot extends CommandBase {

    private Shooter shooter;
    public double vel = 0;

    public Shoot(Shooter shooter) {
        this.shooter = shooter;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        shooter.setVelocity(vel);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
