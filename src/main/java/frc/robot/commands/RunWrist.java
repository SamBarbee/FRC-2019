package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;



public class RunWrist extends Command{
	private double power = 0;
	
	public RunWrist() {
		requires(Robot.intake);
			}
	public RunWrist(double power) {
		requires(Robot.intake);
		this.power = power;
			}
	@Override
	protected void initialize() {
	}
	public void execute() {
		//Robot.intake.setMotors(power);
	}
	protected boolean isFinished() {
		return false;
	}
	protected void end() {
		//Robot.intake.setMotors(0);
			}
	protected void interrupted() {
		//Robot.intake.setMotors(0);
	}
}
