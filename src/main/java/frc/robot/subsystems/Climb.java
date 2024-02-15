// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climb extends SubsystemBase {
  CANSparkMax elevatorMotor;
  CANSparkMax climbMotor;
  DigitalInput climbLimitSwitch;

  /** Creates a new Climb. */
  public Climb() {
    elevatorMotor = new CANSparkMax(Constants.ClimbConstants.elevatorMotorID, CANSparkLowLevel.MotorType.kBrushed);
    climbMotor = new CANSparkMax(Constants.ClimbConstants.climbMotorID, CANSparkLowLevel.MotorType.kBrushless);

    elevatorMotor.setIdleMode(IdleMode.kBrake);
    climbMotor.setIdleMode(IdleMode.kBrake);

    climbLimitSwitch = new DigitalInput(1);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void elevatorMotorForward() {
    elevatorMotor.set(-Constants.ClimbConstants.elevatorSpeed);
  }
    
  public void elevatorMotorReverse() {
    // if (!climbLimitSwitch.get()) {
      elevatorMotor.set(Constants.ClimbConstants.elevatorSpeed);
    // }
  }


  public void elevatorMotorStop() {
    elevatorMotor.set(0);
  }

  public Command elevatorUp() {
    return runEnd(this::elevatorMotorForward, this::elevatorMotorStop);
  }

  public Command elevatorDown() {
    return runEnd(this::elevatorMotorReverse, this::elevatorMotorStop);
  }


  public void climbMotorForward() {
    climbMotor.set(Constants.ClimbConstants.climbSpeed);
  }
    
  public void climbMotorReverse() {
    climbMotor.set(-Constants.ClimbConstants.climbSpeed);
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