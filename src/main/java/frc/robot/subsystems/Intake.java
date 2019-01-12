package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.RunIntake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	private VictorSPX leftMotor;
	// public VictorSP climber;
	public Intake() {
		leftMotor  = new VictorSPX(RobotMap.INTAKE_LEFT);
		// climber = new VictorSP(0);
	}
	protected void initDefaultCommand(){
		setDefaultCommand(new RunIntake(0));
	}
	public void setMotors (double power) {
		leftMotor.set(ControlMode.PercentOutput, power);
		// rightMotor.set(ControlMode.PercentOutput, power);
	}
	// public void runClimber(double power) {
	// 	climber.set(power);
	// }
}