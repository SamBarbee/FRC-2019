package frc.robot.commands;

import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class RunElevator extends Command{
	private double power = 0;
	public RunElevator() {
		requires(Robot.elevator);
	}
	public RunElevator(double power) {
		requires(Robot.elevator);
		this.power = power;
	}
	@Override
	protected void initialize() {
	}
	public void execute() {
		Robot.elevator.motor4.set(ControlMode.PercentOutput, 0.2);
	}
	protected boolean isFinished() {
		return false;
	}
	protected void end() {
		Robot.elevator.setMotors(0);
	}
	protected void interrupted() {
		Robot.elevator.setMotors(0);
	}
}