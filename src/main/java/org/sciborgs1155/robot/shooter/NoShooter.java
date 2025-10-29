package org.sciborgs1155.robot.shooter;

public class NoShooter implements ShooterIO{
    @Override
    public void setVoltage(double topVolt, double bottomVolt) {}

    @Override
    public double topVelocity() {
        return 0.0;
    } 

    @Override
    public double bottomVelocity() {
        return 0.0;
    }

    public void close() {}
}
