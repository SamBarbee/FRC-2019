package frc.robot.subsystems;

import frc.robot.RobotMap;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.commands.BallWithJoystick;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BallRoller extends Subsystem{
	TalonSRX LeftRoller;
	TalonSRX RightRoller;
	public BallRoller() {
		LeftRoller  = new TalonSRX(RobotMap.LEFT_ROLLER);
		RightRoller  = new TalonSRX(RobotMap.RIGHT_ROLLER);

		LeftRoller.setNeutralMode(NeutralMode.Brake);
		RightRoller.setNeutralMode(NeutralMode.Brake);

		LeftRoller.setInverted(true);
		RightRoller.setInverted(true);
	}
	protected void initDefaultCommand(){
		setDefaultCommand(new BallWithJoystick());
	}
	public void setMotors (double power) {
		LeftRoller.set(ControlMode.PercentOutput, power);
		RightRoller.set(ControlMode.PercentOutput, power);
	}
}