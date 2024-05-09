// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.RevAndShoot;
import frc.robot.constants.Constants.OperatorConstants;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.shooter.ShooterSubsystem;
import frc.robot.subsystems.shooter.states.Idle;
import frc.robot.subsystems.shooter.states.Intake;
import frc.robot.subsystems.shooter.states.Rev;
import frc.robot.subsystems.shooter.states.Shoot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ShooterSubsystem shooter = new ShooterSubsystem();

  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    configureBindings();
    setDefaultCommands();
  }

  public void setDefaultCommands() {
    shooter.setDefaultCommand(new Idle(shooter));
  }

  private void configureBindings() {
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    m_driverController.b().whileTrue(new Intake(shooter));
    m_driverController.leftBumper().whileTrue(new RevAndShoot(shooter));
    m_driverController.rightBumper().whileTrue(new Rev(shooter));
  }

  public Command getAutonomousCommand() {
    return new RevAndShoot(shooter);
  }
}
