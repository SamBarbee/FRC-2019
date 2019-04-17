package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class SetPushy extends Command{

	boolean b;
	int d;
	
	public SetPushy() {
		requires(Robot.hatchroller);
		b = false;
			}
	public SetPushy(boolean a) {
		requires(Robot.hatchroller);
		b = a;
	}
	public SetPushy(int c) {
		requires(Robot.hatchroller);
		d = c;
	}
	@Override
	protected void initialize() {
	}
	public void execute() {
		if(d==1) {
			if(Robot.hatchroller.push.get() == Value.kForward)
				Robot.hatchroller.setPush(false);
			if(Robot.hatchroller.push.get() == Value.kReverse)
				Robot.hatchroller.setPush(true);
			if(Robot.hatchroller.push.get() == Value.kOff)
				Robot.hatchroller.setPush(true);
		}
		else {
			Robot.hatchroller.setPush(b);
		}
		

	}
	protected boolean isFinished() {
		return true;
	}
	protected void end() {
			}
	protected void interrupted() {
	}
}
