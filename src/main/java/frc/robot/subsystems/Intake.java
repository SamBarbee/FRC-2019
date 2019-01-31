package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.RunIntake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	TalonSRX IntakeMotor;
	public Intake() {
		IntakeMotor  = new TalonSRX(RobotMap.HACTH_ROLLER);
	}
	protected void initDefaultCommand(){
		setDefaultCommand(new RunIntake(0));
	}
	public void setHatchRoller (double power) {
		IntakeMotor.set(ControlMode.PercentOutput, power);
	}
}