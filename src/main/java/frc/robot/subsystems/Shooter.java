// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Shooter extends SubsystemBase {
  CANSparkMax leftFeedLeadMotor;
  CANSparkMax leftShootLeadMotor;
  CANSparkMax rightFeedFollowMotor;
  CANSparkMax rightShootFollowMotor;
  SparkPIDController leftFeedLeadPid;
  SparkPIDController leftShootLeadPid;
  SparkPIDController rightFeedFollowPid;
  SparkPIDController rightShootFollowPid;
  Timer timer;

  /** Creates a new ExampleSubsystem. */
  public Shooter() {
    leftFeedLeadMotor = new CANSparkMax(Constants.ShooterConstants.leftFeedLeadMotor, MotorType.kBrushless);
    leftShootLeadMotor = new CANSparkMax(Constants.ShooterConstants.leftShootLeadMotor, MotorType.kBrushless);
    rightFeedFollowMotor = new CANSparkMax(Constants.ShooterConstants.rightFeedFollowMotor, MotorType.kBrushless);
    rightShootFollowMotor = new CANSparkMax(Constants.ShooterConstants.rightShootFollowMotor, MotorType.kBrushless);

    leftFeedLeadPid = leftFeedLeadMotor.getPIDController();
    leftShootLeadPid = leftShootLeadMotor.getPIDController();
    rightFeedFollowPid = rightFeedFollowMotor.getPIDController();
    rightShootFollowPid = rightShootFollowMotor.getPIDController();

    SmartDashboard.putNumber("leftshooterSpeed", 0);
    SmartDashboard.putNumber("rightshooterSpeed", 0);
    SmartDashboard.putNumber("leftfeedSpeed", 0);
    SmartDashboard.putNumber("rightfeedSpeed", 0);


  }

  public void runFeedMotors() {
    leftFeedLeadPid.setReference(SmartDashboard.getNumber("leftfeedSpeed", 0),ControlType.kVelocity);
    rightFeedFollowPid.setReference(-SmartDashboard.getNumber("rightfeedSpeed", 0),ControlType.kVelocity);
  }

  public void stopFeedMotors() {
    leftFeedLeadPid.setReference(0,ControlType.kVelocity);
    rightFeedFollowPid.setReference(0,ControlType.kVelocity);
  }

  public void runShooterMotors() {
    // leftShootLeadPid.setReference(Constants.ShooterConstants.leftshooterSpeed,ControlType.kVelocity);
    leftShootLeadPid.setReference(SmartDashboard.getNumber("leftshooterSpeed", 0),ControlType.kVelocity);

    // rightShootFollowPid.setReference(-Constants.ShooterConstants.rightshooterSpeed,ControlType.kVelocity);
    rightShootFollowPid.setReference(-SmartDashboard.getNumber("rightshooterSpeed", 0),ControlType.kVelocity);

  }

  public void reverseShooterMotors() {
    leftShootLeadPid.setReference(-Constants.ShooterConstants.leftshooterSpeed,ControlType.kVelocity);
  }

  public void stopShooterMotors() {
    leftShootLeadPid.setReference(0,ControlType.kVelocity);
    rightShootFollowPid.setReference(0,ControlType.kVelocity);
  }

  public double getShooterMotorSpeed() {
    return leftFeedLeadMotor.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}