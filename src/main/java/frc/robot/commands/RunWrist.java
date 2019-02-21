package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;



public class RunWrist extends Command{
	
	public RunWrist() {
		requires(Robot.wrist);
			}
	@Override
	protected void initialize() {
	}
	public void execute() {
		//Robot.wrist.setMotors(Robot.OI.getWristStick());
	}
	protected boolean isFinished() {
		return false;
	}
	protected void end() {
		Robot.wrist.setMotors(0);
			}
	protected void interrupted() {
		Robot.wrist.setMotors(0);
	}
}
