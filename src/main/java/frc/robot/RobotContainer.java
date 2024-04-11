// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.PID;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final PID pid = new PID();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  public static XboxController testController = new XboxController(0);

  // private final JoystickButton elevatorUpButton = new JoystickButton(lilyShade, XboxController.Button.kY.value);
  // private final JoystickButton elevatorDownButton = new JoystickButton(testController, XboxController.Button.kA.value);

  // private final JoystickButton intakeElevatorButton = new JoystickButton(lilyShade, XboxController.Button.kX.value);
  // private final JoystickButton outtakeElevatorButton = new JoystickButton(testController, XboxController.Button.kB.value);
  


  /* Commands */
  // private final Command elevatorUp = elevator.elevatorUp();
  // private final Command elevatorDown = elevator.elevatorDown();

  // private final Command intakeElevator = elevator.intakeElevatorCommand();
  // private final Command outtakeElevator = elevator.outtakeElevatorCommand();





  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // new Trigger(m_shooter::exampleCondition)
    // .onTrue(new Shoot(m_shooter));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is
    // pressed,
    // cancelling on release.
    // driver.b().whileTrue(m_shooter.exampleMethodCommand());
    // elevatorUpButton.whileTrue(elevatorUp);
    // elevatorDownButton.whileTrue(elevatorDown);
    // intakeElevatorButton.whileTrue(intakeElevator);
    // outtakeElevatorButton.whileTrue(outtakeElevator);


    // lilyShade.leftTrigger(0.5, m_climb.climbLeft());
    // lilyShade.rightTrigger(0.5, m_climb.climbRight());

    // climbRightButton.whileTrue(climbRight);
    // climbLeftButton.whileTrue(climbLeft);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}