// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter.states;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.RobotConstants;
import frc.robot.subsystems.shooter.ShooterSubsystem;

public class Shoot extends Command {
  
  ShooterSubsystem shooter;

  public Shoot(ShooterSubsystem shooter) {
    this.shooter = shooter;
    addRequirements(shooter);
  }

  @Override
  public void initialize() {
    shooter.SetShooterMotorPower(RobotConstants.ShooterConstants.SHOOT_POWER_SHOOTER);
    shooter.SetFeedMotorPower(RobotConstants.ShooterConstants.SHOOT_POWER_FEED);
  }
}
