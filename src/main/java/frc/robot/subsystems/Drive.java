// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  private final TalonSRX mFrontLeft;
  /** Creates a new Drive. */
  public Drive(TalonSRX FL) {
    this.mFrontLeft=FL;
  }

  //HELP ME I CANT TEACH :c

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
