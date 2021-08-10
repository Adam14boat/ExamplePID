package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;

public class Shooter extends SubsystemBase {

    private TalonFX master = new TalonFX(Ports.Shooter.MASTER);
    private TalonFX slave = new TalonFX(Ports.Shooter.SLAVE);

    public Shooter() {
        slave.follow(master);

        master.setInverted(Ports.Shooter.IS_MASTER_INVERTED);
        slave.setInverted(Ports.Shooter.IS_SLAVE_INVERTED);

        master.setSensorPhase(Ports.Shooter.IS_SENSOR_PHASE_INVERTED);

        master.config_kP(0, Constants.Shooter.KP, Constants.Shooter.TALON_TIMEOUT);
        master.config_kI(0, Constants.Shooter.KI, Constants.Shooter.TALON_TIMEOUT);
        master.config_kD(0, Constants.Shooter.KD, Constants.Shooter.TALON_TIMEOUT);
    }

    public void setVelocity(double velocity) {
        master.set(ControlMode.Velocity, velocity);
    }

    public void stop() {
        master.set(ControlMode.PercentOutput, 0);
    }

    public double getVelocity() {
        return master.getSelectedSensorVelocity();
    }

}
