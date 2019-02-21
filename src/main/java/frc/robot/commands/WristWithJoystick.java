package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class WristWithJoystick extends Command {
	public WristWithJoystick() {
		requires(Robot.wrist);
	}
	@Override
	protected void initialize() {
	}
	public void execute() {
		Robot.wrist.setMotors(Robot.OI.getWristSpeed());
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