package org.sciborgs1155.robot.shooter;

import org.sciborgs1155.robot.Ports;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.config.SparkMaxConfig;

public class Shooter extends SubsystemBase implements ShooterIO{
    private final SparkMax topMotor = new SparkMax(Ports.Shooter.TOP_MOTOR, MotorType.kBrushless);
    private final SparkMax bottomMotor = new SparkMax(Ports.Shooter.BOTTOM_MOTOR, MotorType.kBrushless);
    private final RelativeEncoder topEncoder = topMotor.getEncoder();
    private final RelativeEncoder bottomEncoder = bottomMotor.getEncoder();

    public Shooter() {
        SparkMaxConfig globalConfig = new SparkMaxConfig();
        SparkMaxConfig topMotorConfig = new SparkMaxConfig();
        SparkMaxConfig bottomMotorConfig = new SparkMaxConfig();

        globalConfig.idleMode(IdleMode.kBrake);

        topMotorConfig.apply(globalConfig).inverted(true).encoder.positionConversionFactor(ShooterConstants.POSITION_FACTOR).velocityConversionFactor(ShooterConstants.VELOCITY_FACTOR);
        bottomMotorConfig.apply(globalConfig).inverted(false).encoder.positionConversionFactor(ShooterConstants.POSITION_FACTOR).velocityConversionFactor(ShooterConstants.VELOCITY_FACTOR);

        topMotor.configure(topMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
        bottomMotor.configure(bottomMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);

        topEncoder.setPosition(0);
        bottomEncoder.setPosition(0);
    }

    @Override
    public void setVoltage(double topVolt, double bottomVolt) {
        topMotor.setVoltage(topVolt);
        bottomMotor.setVoltage(bottomVolt);
    }

    @Override
    public double topVelocity() {
        return topEncoder.getVelocity();
    } 

    @Override
    public double bottomVelocity() {
        return bottomEncoder.getVelocity();
    }

    public void close() {
        topMotor.close();
        bottomMotor.close();
    }
}
