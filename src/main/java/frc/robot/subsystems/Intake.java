package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.RunIntake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	VictorSPX IntakeMotor;
	public Intake() {
		IntakeMotor  = new VictorSPX(RobotMap.INTAKE_MOTOR);
		// climber = new VictorSP(0);
	}
	protected void initDefaultCommand(){
		setDefaultCommand(new RunIntake(0));
	}
	public void setMotors (double power) {
		IntakeMotor.set(ControlMode.PercentOutput, power);
	}
}