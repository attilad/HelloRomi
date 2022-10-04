// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.XboxController;

/** Educational robot base class. */
public class EducationalRobot extends RobotBase {
  private RomiDrivetrain m_Drivetrain;
  private XboxController m_driverController;
  

  public void robotInit() 
  {
    m_Drivetrain = new RomiDrivetrain();
    m_driverController = new XboxController(0);

    m_Drivetrain.arcadeDrive(m_driverController.getLeftY(), m_driverController.getRightX());
  }

  public void disabled() {}

  public void run() {}

  public void autonomous() {
    run();
  }

  public void teleop() {
    run();
  }

  public void test() {
    run();
  }

  private volatile boolean m_exit;

  @Override
  public void startCompetition() {
    robotInit();

    // Tell the DS that the robot is ready to be enabled
    HAL.observeUserProgramStarting();

    while (!Thread.currentThread().isInterrupted() && !m_exit) {
      if (isDisabled()) {
        DriverStation.inDisabled(true);
        disabled();
        DriverStation.inDisabled(false);
        while (isDisabled()) {
          DriverStation.waitForData();
        }
      } else if (isAutonomous()) {
        DriverStation.inAutonomous(true);
        autonomous();
        DriverStation.inAutonomous(false);
        while (isAutonomousEnabled()) {
          DriverStation.waitForData();
        }
      } else if (isTest()) {
        DriverStation.inTest(true);
        test();
        DriverStation.inTest(false);
        while (isTest() && isEnabled()) {
          DriverStation.waitForData();
        }
      } else {
        DriverStation.inTeleop(true);
        teleop();
        DriverStation.inTeleop(false);
        while (isTeleopEnabled()) {
          DriverStation.waitForData();
        }
      }
    }
  }

  @Override
  public void endCompetition() {
    m_exit = true;
  }
}
