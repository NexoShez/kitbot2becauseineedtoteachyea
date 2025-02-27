// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.OutTake;

public class RobotContainer {
  private final Drive mDrive;
  private final OutTake mOuttake;
  
  private final CommandXboxController m_driverController =
      new CommandXboxController(0);

  public RobotContainer() { // 15, 2,14,0
    TalonSRX outtake = new TalonSRX(1);
    outtake.setInverted(false);
    outtake.configPeakCurrentLimit(40);
    mOuttake = new OutTake(outtake);


    TalonSRX driveFL = new TalonSRX(15);
    TalonSRX driveFR = new TalonSRX(2);
    TalonSRX driveBL = new TalonSRX(14);
    TalonSRX driveBR = new TalonSRX(10);

    // settings

    driveFL.setInverted(false);
    driveFR.setInverted(false);
    driveBL.setInverted(false);
    driveBR.setInverted(false);

    driveFL.configPeakCurrentLimit(40);
    driveFR.configPeakCurrentLimit(40);
    driveBL.configPeakCurrentLimit(40);
    driveBR.configPeakCurrentLimit(40);

    mDrive = new Drive(driveFL, driveFR, driveBL, driveBR);

    mDrive.setDefaultCommand(
      new RunCommand(() -> mDrive.SetSpeed(
        m_driverController.getLeftY(),
        m_driverController.getRightY()
        ),
         mDrive
      )
    );

    configureBindings();
  }

  private void configureBindings() {
    m_driverController.leftBumper().onTrue(
      Commands.runOnce(
        () -> mOuttake.setSpeed(-.8), 
        mOuttake
      )
    ).onFalse(
      Commands.run(() -> mOuttake.setSpeed(0), mOuttake)
    );
    
    m_driverController.rightBumper().onTrue(
      Commands.runOnce(
        () -> mOuttake.setSpeed(.8), 
        mOuttake
      )
    ).onFalse(
      Commands.run(() -> mOuttake.setSpeed(0), mOuttake)
    );
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
