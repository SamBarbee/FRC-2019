/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetWrist extends Command {

  double m_position;
  boolean m_isFinished;
  public SetWrist() {
    requires(Robot.wrist);
  }

  public SetWrist(double position) {
    requires(Robot.wrist);

    m_position = position;
    m_isFinished = false;
  }
  @Override
  protected void initialize() {
    m_isFinished = false;
  }
  @Override
  protected void execute() {
        Robot.wrist.SetWristPosition(m_position);
        m_isFinished = true;
  }
  @Override
  protected boolean isFinished() {
    return m_isFinished;
  }
  @Override
  protected void end() {
  }
  @Override
  protected void interrupted() {
    end();
  }
}
