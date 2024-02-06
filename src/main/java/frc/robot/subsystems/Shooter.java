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
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Shooter extends SubsystemBase {
  CANSparkMax leftFeedLeadMotor;
  CANSparkMax leftShootLeadMotor;
  CANSparkMax rightFeedFollowMotor;
  CANSparkMax rightShootFollowMotor;
  Timer timer;

  /** Creates a new ExampleSubsystem. */
  public Shooter() {
    leftFeedLeadMotor = new CANSparkMax(Constants.ShooterConstants.leftFeedLeadMotor, MotorType.kBrushless);
    leftShootLeadMotor = new CANSparkMax(Constants.ShooterConstants.leftShootLeadMotor, MotorType.kBrushless);
    rightFeedFollowMotor = new CANSparkMax(Constants.ShooterConstants.rightFeedFollowMotor, MotorType.kBrushless);
    rightShootFollowMotor = new CANSparkMax(Constants.ShooterConstants.rightShootFollowMotor, MotorType.kBrushless);

    leftFeedLeadMotor.restoreFactoryDefaults();
    leftShootLeadMotor.restoreFactoryDefaults();
    rightFeedFollowMotor.restoreFactoryDefaults();
    rightShootFollowMotor.restoreFactoryDefaults();

    SmartDashboard.putNumber("leftshooterSpeed", 0);
    SmartDashboard.putNumber("rightshooterSpeed", 0);
    SmartDashboard.putNumber("leftfeedSpeed", 0);
    SmartDashboard.putNumber("rightfeedSpeed", 0);


  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a
   * digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */

  public void runFeedMotors() {
    leftFeedLeadMotor.set(SmartDashboard.getNumber("leftfeedSpeed", 0));
    rightFeedFollowMotor.set(-SmartDashboard.getNumber("rightfeedSpeed", 0));
  }

  public void stopFeedMotors() {
    leftFeedLeadMotor.set(0);
    rightFeedFollowMotor.set(0);
  }

  public void runShooterMotors() {
    // leftShootLeadMotor.set(Constants.ShooterConstants.leftshooterSpeed);
    leftShootLeadMotor.set(SmartDashboard.getNumber("leftshooterSpeed", 0));

    // rightShootFollowMotor.set(-Constants.ShooterConstants.rightshooterSpeed);
    rightShootFollowMotor.set(SmartDashboard.getNumber("rightshooterSpeed", 0));

  }

  public void reverseShooterMotors() {
    leftShootLeadMotor.set(-Constants.ShooterConstants.leftshooterSpeed);
  }

  public void stopShooterMotors() {
    leftShootLeadMotor.set(0);
    rightShootFollowMotor.set(0);
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