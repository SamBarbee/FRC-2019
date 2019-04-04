package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;



public class RunBall extends Command{
	private double power = 0;
	
	public RunBall() {
		requires(Robot.ballroller);
			}
	public RunBall(double power) {
		requires(Robot.ballroller);
		this.power = power;
			}
	@Override
	protected void initialize() {
	}
	public void execute() {
		Robot.ballroller.setMotors(power);
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