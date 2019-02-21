package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;



public class RunHatch extends Command{
	private double power = 0;
	
	public RunHatch() {
		requires(Robot.hatchroller);
			}
	public RunHatch(double power) {
		requires(Robot.hatchroller);
		this.power = power;
			}
	@Override
	protected void initialize() {
	}
	public void execute() {
		Robot.hatchroller.setMotors(power);
	}
	protected boolean isFinished() {
		return false;
	}
	protected void end() {
		Robot.hatchroller.setMotors(0);
			}
	protected void interrupted() {
		Robot.hatchroller.setMotors(0);
	}
}