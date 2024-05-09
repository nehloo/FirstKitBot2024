// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.shooter.ShooterSubsystem;
import frc.robot.subsystems.shooter.states.Idle;
import frc.robot.subsystems.shooter.states.Rev;
import frc.robot.subsystems.shooter.states.Shoot;

public class RevAndShoot extends SequentialCommandGroup {
  
  public RevAndShoot(ShooterSubsystem shooter) {
    addCommands(
      new Rev(shooter).withTimeout(0.5),
      new Shoot(shooter).withTimeout(1),
      new Idle(shooter)
    );
  }
}
