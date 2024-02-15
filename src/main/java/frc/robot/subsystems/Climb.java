// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ClimbConstants;

public class Climb extends SubsystemBase {
  private CANSparkMax climbMotor;
  private RelativeEncoder climbEncoder;
  private SparkPIDController pidController;


  /** Creates a new Climb. */
  public Climb() {
    climbMotor = new CANSparkMax(Constants.ClimbConstants.climbMotorID, CANSparkLowLevel.MotorType.kBrushless);
    pidController.setP(0.02);
    climbEncoder = climbMotor.getEncoder();
    //climbEncoder.setPositionConversionFactor(0);

    climbMotor.setIdleMode(IdleMode.kBrake);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void climbMotorForward() {
    pidController.setReference(
        ClimbConstants.rotations, 
        CANSparkBase.ControlType.kPosition);
    //climbMotor.set(Constants.ClimbConstants.climbSpeed);
  }
    
  public void climbMotorReverse() {
    pidController.setReference(
            -ClimbConstants.rotations, 
            CANSparkBase.ControlType.kPosition);
    //climbMotor.set(-Constants.ClimbConstants.climbSpeed);
  }

  public void climbMotorStop() {
    climbMotor.set(0);
  }

  public Command climbUp() {
    return runEnd(this::climbMotorForward, this::climbMotorStop);
  }

  public Command climbDown() {
    return runEnd(this::climbMotorReverse, this::climbMotorStop);
  }
}