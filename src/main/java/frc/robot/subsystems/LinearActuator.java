// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ClimbConstants;
import frc.robot.RobotContainer;

public class LinearActuator extends SubsystemBase {
  private CANSparkMax leftClimb;
  private CANSparkMax rightClimb;
  private RelativeEncoder leftClimbEncoder;
  private SparkPIDController leftPIDController;
  private SparkPIDController rightPIDController;
  private double elevatorRotations;
  private double leftTriggerAxis;
  private double rightTriggerAxis;
  private boolean leftBumper;
  private boolean rightBumper;

  /** Creates a new Climb. */
  public LinearActuator() {
    // leftClimb = new CANSparkMax(ClimbConstants.leftClimbMotorID, CANSparkLowLevel.MotorType.kBrushless);
    // rightClimb = new CANSparkMax(ClimbConstants.rightClimbMotorID, CANSparkLowLevel.MotorType.kBrushless);

    // leftPIDController = leftClimb.getPIDController();
    // rightPIDController = rightClimb.getPIDController();
    // leftPIDController.setP(0.02);
    // rightPIDController.setP(0.02);

    leftClimbEncoder = leftClimb.getEncoder();
    leftClimbEncoder.setPositionConversionFactor(0.50);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("elevator rotations", this.getElevatorRotation());
    elevatorRotations = leftClimbEncoder.getPosition();

    leftTriggerAxis = RobotContainer.testController.getLeftTriggerAxis();
    rightTriggerAxis = RobotContainer.testController.getRightTriggerAxis();
    leftBumper = RobotContainer.testController.getLeftBumper();
    rightBumper = RobotContainer.testController.getRightBumper();
    if (leftTriggerAxis == 1) {
      climbLeftMotor(); climbRightMotor();
    } else if (rightTriggerAxis == 1) {
      retractLeftMotor(); retractRightMotor();
    } else if (leftBumper) {
      climbLeftMotor(); retractRightMotor();
    } else if (rightBumper) {
      climbRightMotor(); retractLeftMotor();
    } else {
      stopLeft(); stopRight();
    }

  }

  public double getElevatorRotation() {
    return leftClimbEncoder.getPosition();
  }

  public void climbRightMotor() {
      // rightPIDController.setReference(
      //   ClimbConstants.rotations, 
      //   CANSparkBase.ControlType.kPosition);
    
    // rightClimb.set(Constants.ClimbConstants.climbSpeed);
  }

  public void climbLeftMotor() {
      // leftPIDController.setReference(
      //   ClimbConstants.rotations, 
      //   CANSparkBase.ControlType.kPosition);    
    
    // leftClimb.set(Constants.ClimbConstants.climbSpeed);
  }

  public void retractRightMotor() {
      // rightPIDController.setReference(
      //   -ClimbConstants.rotations, 
      //   CANSparkBase.ControlType.kPosition);

    // rightClimb.set(-Constants.ClimbConstants.climbSpeed);
  }

  public void retractLeftMotor() {
    // leftPIDController.setReference(
    //     -ClimbConstants.rotations,
    //     CANSparkBase.ControlType.kPosition);

    // leftClimb.set(-Constants.ClimbConstants.climbSpeed);
  }

  public void stopLeft() {
    leftClimb.set(0);
  }

  public void stopRight() {
    rightClimb.set(0);
  }

  public void climbMotors() {
    climbLeftMotor();
    climbRightMotor();
  }

  public void retractMotors() {
    retractLeftMotor();
    retractRightMotor();
  }

  public void stopMotors() {
    stopLeft();
    stopRight();
  }

  /* Commands */
  // public Command climbLeft() {
  //   return runEnd(this::climbMotors, this::stopMotors);
  // }

  // public Command climbRight() {
  //   return runEnd(this::climbRightMotor, this::stopMotors);
  // }

  public Command retractLeft() {
    return runEnd(this::retractLeftMotor, this::stopLeft);
  }

  public Command retractRight() {
    return runEnd(this::retractRightMotor, this::stopRight);
  }
}