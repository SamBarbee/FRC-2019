package frc.robot.subsystems;

import frc.robot.RobotMap;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchRoller extends Subsystem{
	TalonSRX HatchMotor;

	DoubleSolenoid push;

	public HatchRoller() {
		HatchMotor  = new TalonSRX(RobotMap.HATCH_ROLLER);

		push = new DoubleSolenoid(RobotMap.HATCH_PUSH, RobotMap.HATCH_PULL);

		HatchMotor.setInverted(false);

	}
	protected void initDefaultCommand(){
		//setDefaultCommand(new BallWithJoystick());
	}
	public void setMotors (double power) {
		HatchMotor.set(ControlMode.PercentOutput, power);
	}
	public void setPush(boolean a) {
		if(a){push.set(Value.kForward);}
		if(!a){push.set(Value.kReverse);}
	}
	
}