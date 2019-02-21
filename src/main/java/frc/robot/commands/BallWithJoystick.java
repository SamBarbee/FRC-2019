package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class BallWithJoystick extends Command {
	public BallWithJoystick() {
		requires(Robot.ballroller);
	}
	@Override
	protected void initialize() {
	}
	public void execute() {
		Robot.ballroller.setMotors(Robot.OI.getBallSpeed());
	}
	protected boolean isFinished() {
		return false;
	}
	protected void end() {
		Robot.ballroller.setMotors(0);
	}
	protected void interrupted() {
		Robot.ballroller.setMotors(0);
	}
} 