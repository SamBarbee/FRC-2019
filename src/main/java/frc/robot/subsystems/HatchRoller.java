package frc.robot.subsystems;

import frc.robot.RobotMap;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchRoller extends Subsystem{
	TalonSRX HatchMotor;
	TalonSRX LeftRoller;
	TalonSRX RightRoller;
	public HatchRoller() {
		HatchMotor  = new TalonSRX(RobotMap.HACTH_ROLLER);

		HatchMotor.setInverted(true);

	}
	protected void initDefaultCommand(){
		//setDefaultCommand(new BallWithJoystick());
	}
	public void setMotors (double power) {
		HatchMotor.set(ControlMode.PercentOutput, power);
	}
	
}