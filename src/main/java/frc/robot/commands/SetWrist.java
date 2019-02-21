/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
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
      if(m_position > Constants.WRIST_ZERO) {
        Robot.wrist.SetWristPosition(m_position, Constants.WRIST_F);
        m_isFinished = true;
      }

      if(m_isFinished == false)
      {
        if(Robot.wrist.GetWristPosition() > Constants.WRIST_ZERO_NEUTRAL_POSITION )
        {
          Robot.wrist.SetWristPosition(m_position, Constants.WRIST_F_DOWN);
        }
        else
        {

          if(Robot.wrist.GetWristPosition() < Constants.WRIST_ZERO_NEUTRAL_POSITION_DEADBAND)
          {
            Robot.wrist.SetWristPosition(m_position, Constants.WRIST_ZERO_F);
            m_isFinished = true;

          }
          double slope = (Constants.WRIST_F_DOWN - Constants.WRIST_ZERO_F) / (Constants.WRIST_ZERO_NEUTRAL_POSITION - Constants.WRIST_ZERO_NEUTRAL_POSITION_DEADBAND);
          double y_intercept = Constants.WRIST_ZERO_F - (slope*Constants.WRIST_ZERO_NEUTRAL_POSITION_DEADBAND);
          double linear_F = slope*(Robot.wrist.GetWristPosition()) + y_intercept;
          Robot.wrist.SetWristPosition(m_position, linear_F);
        }
      }
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
