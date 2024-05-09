// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter.states;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.RobotConstants;
import frc.robot.subsystems.shooter.ShooterSubsystem;

public class Rev extends Command {
  
  ShooterSubsystem shooter;

  public Rev(ShooterSubsystem shooter) {
    this.shooter = shooter;
    addRequirements(shooter);
  }

  @Override
  public void initialize() {
    shooter.SetFeedMotorPower(0);
    shooter.SetShooterMotorPower(RobotConstants.ShooterConstants.REV_POWER_SHOOTER);
  }
}
