// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.HardwareMap;

public class ShooterSubsystem extends SubsystemBase {

  TalonSRX feedMotor = new TalonSRX(HardwareMap.FEED_MOTOR_ID);
  TalonSRX shooterMotor = new TalonSRX(HardwareMap.SHOOTER_MOTOR_ID);

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {}

  public void SetFeedMotorPower(double motorPower) {
    feedMotor.set(TalonSRXControlMode.PercentOutput, motorPower);
  }
  public void SetShooterMotorPower(double motorPower) {
    shooterMotor.set(TalonSRXControlMode.PercentOutput, motorPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
