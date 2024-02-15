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

public class Elevator extends SubsystemBase {
  CANSparkMax elevatorMotor;
  DigitalInput climbLimitSwitch;


  /** Creates a new Elevator. */
  public Elevator() {
    elevatorMotor = new CANSparkMax(Constants.ClimbConstants.elevatorMotorID, CANSparkLowLevel.MotorType.kBrushed);
    elevatorMotor.setIdleMode(IdleMode.kBrake);

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

}
