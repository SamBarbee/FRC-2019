package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;



public class SetPushy extends Command{

	boolean b;
	
	public SetPushy() {
		requires(Robot.hatchroller);
		b = false;
			}
	public SetPushy(boolean a) {
		requires(Robot.hatchroller);
		b = a;
	}
	@Override
	protected void initialize() {
	}
	public void execute() {
		Robot.hatchroller.setPush(b);
	}
	protected boolean isFinished() {
		return true;
	}
	protected void end() {
			}
	protected void interrupted() {
	}
}
