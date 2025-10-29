package org.sciborgs1155.robot.shooter;

import org.sciborgs1155.robot.Robot;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase implements AutoCloseable{
    private ShooterIO hardware;
    private final PIDController topPID = new PIDController(ShooterConstants.kP, ShooterConstants.kI, ShooterConstants.kD);

    public static Shooter create(){
        return Robot.isReal() ?
        new Shooter(new RealShooter()) :
        new Shooter(new NoShooter());
    }

    public static Shooter none() {
        return new Shooter(new NoShooter());
    }

    public Shooter(ShooterIO hardware) {
        this.hardware = hardware;
    }

    public void close() throws Exception {
        hardware.close();
    }
/*
    public void update(double setpoint) {
        double velocity = 
        Double.isNaN(velocitySetpoint) ?
            DEFAULT_VELOCITY.in(RadiansPerSecond) :

    }
*/
}
