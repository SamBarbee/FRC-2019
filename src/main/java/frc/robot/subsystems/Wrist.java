package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.RunWrist;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Wrist extends Subsystem{
	private VictorSPX leftMotor, rightMotor;
	public VictorSP climber;
	public Wrist() {
		//leftMotor  = new VictorSPX(RobotMap.INTAKE_LEFT);
		rightMotor = new VictorSPX(RobotMap.WRIST);
	}
	protected void initDefaultCommand(){
		setDefaultCommand(new RunWrist(0));
	}
	public void setMotors (double power) {
		leftMotor.set(ControlMode.PercentOutput, power);
		rightMotor.set(ControlMode.PercentOutput, power);
	}
}