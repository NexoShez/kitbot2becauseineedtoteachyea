// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OutTake extends SubsystemBase {
  private TalonSRX outtake;
  /** Creates a new OutTake. */
  public OutTake(TalonSRX x) {
    outtake=x;
  }

  public void setSpeed(double speed) {
    outtake.set(TalonSRXControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
