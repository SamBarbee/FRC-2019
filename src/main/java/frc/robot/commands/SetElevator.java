/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Constants;

public class SetElevator extends Command {
  
  double m_position;
  boolean m_isFinished;

  public SetElevator(double position) {
    requires(Robot.elevator);
    
    m_position = position;
    m_isFinished = false;
  }
  protected void initialize() {
    m_isFinished = false;
  }

  protected void execute() {
      if(m_position > Constants.ELEVATOR_ZERO) {
        Robot.elevator.SetElevatorPosition(m_position, Constants.ELEVATOR_F);
        m_isFinished = true;
      }

      if(m_isFinished == false)
      {
        if(Robot.elevator.GetElevatorPosition() > Constants.ELEVATOR_ZERO_NEUTRAL_POSITION )
        {
          Robot.elevator.SetElevatorPosition(m_position, Constants.ELEVATOR_F_DOWN);
        }
        else
        {
          if(Robot.elevator.GetElevatorPosition() < Constants.ELEVATOR_ZERO_NEUTRAL_POSITION_DEADBAND)
          {
            Robot.elevator.SetElevatorPosition(m_position, Constants.ELEVATOR_ZERO_F);
            m_isFinished = true;

          }
          double slope = (Constants.ELEVATOR_F_DOWN - Constants.ELEVATOR_ZERO_F) / (Constants.ELEVATOR_ZERO_NEUTRAL_POSITION - Constants.ELEVATOR_ZERO_NEUTRAL_POSITION_DEADBAND);
          double y_intercept = Constants.ELEVATOR_ZERO_F - (slope*Constants.ELEVATOR_ZERO_NEUTRAL_POSITION_DEADBAND);
          double linear_F = slope*(Robot.elevator.GetElevatorPosition()) + y_intercept;
          Robot.elevator.SetElevatorPosition(m_position, linear_F);
        }
      }
  }

  protected void end() {	
  }
      
	protected void interrupted() {
		end();
	}

  protected boolean isFinished() {
    return m_isFinished;
  }

}
