package frc.robot.subsystems;

import frc.robot.RobotMap;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.commands.BallWithJoystick;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BallRoller extends Subsystem{
	TalonSRX Roller;
	public BallRoller() {
		Roller  = new TalonSRX(RobotMap.BALL_ROLLER);

		Roller.setNeutralMode(NeutralMode.Brake);
	
		Roller.setInverted(true);
	
	}
	protected void initDefaultCommand(){
		setDefaultCommand(new BallWithJoystick());
	}
	public void setMotors (double power) {
		Roller.set(ControlMode.PercentOutput, power);
	}
}