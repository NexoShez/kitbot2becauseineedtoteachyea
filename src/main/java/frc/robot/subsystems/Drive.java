// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  private final TalonSRX mFrontLeft;
  private final TalonSRX mFrontRight;
  private final TalonSRX mBackLeft;
  private final TalonSRX mBackRight;

  /** Creates a new Drive. */
  public Drive(TalonSRX FL, TalonSRX FR,TalonSRX BL, TalonSRX BR) {
    this.mFrontLeft=FL;
    this.mFrontRight=FR;
    this.mBackLeft=BL;
    this.mBackRight=BR;
  }

  //HELP ME I CANT TEACH :c

  public void SetSpeed(double left, double right) {
    // neveruse "camelcase" fr

    /*
     * integers = whole number NO DEdCIMELSMMS
     * 
     * doubles = number with or not with decimals
     */

     left=left*-1;

    mFrontLeft.set(TalonSRXControlMode.PercentOutput, left);
    mBackLeft.set(TalonSRXControlMode.PercentOutput, left);
    mFrontRight.set(TalonSRXControlMode.PercentOutput, right);
    mBackRight.set(TalonSRXControlMode.PercentOutput, right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
