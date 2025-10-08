package org.sciborgs1155.robot.shooter;

public interface ShooterIO {
    /**
     * Sets the voltage of the motors
     * @param topVolt voltage to set the top motor to
     * @param bottomVolt voltage to set the bottom motor to
     */
    void setVoltage(double topVolt, double bottomVolt);

    /**
     * gets the top velocity in randians/sec
     * @return double topVelocity in radians/sec
     */
    public double topVelocity();

    /**
     * gets the bottom velocity in randians/sec
     * @return double bottomVelocity in radians/sec
     */
    public double bottomVelocity();
}
