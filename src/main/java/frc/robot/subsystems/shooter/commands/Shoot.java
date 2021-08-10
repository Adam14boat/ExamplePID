package frc.robot.subsystems.shooter.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;
import frc.robot.valuetuner.WebConstant;
import webapp.FireLog;

public class Shoot extends CommandBase {

    private final Shooter shooter;
    public WebConstant vel = new WebConstant("velocity-shooter", 0);

    public Shoot(Shooter shooter) {
        this.shooter = shooter;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        shooter.setVelocity(vel.get());
        FireLog.log("setpoint", vel.get());
        FireLog.log("velocity", shooter.getVelocity());
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
