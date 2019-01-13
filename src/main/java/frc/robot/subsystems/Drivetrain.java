package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoystick;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem{
	
	public static final String NAME = "Drivetrain";
	
	VictorSPX left1 = new VictorSPX(RobotMap.DRIVE_LEFT1);
	VictorSPX left2 = new VictorSPX(RobotMap.DRIVE_LEFT2);
	VictorSPX left3 = new VictorSPX(RobotMap.DRIVE_LEFT3);
	VictorSPX right1 = new VictorSPX(RobotMap.DRIVE_RIGHT1);
	VictorSPX right2 = new VictorSPX(RobotMap.DRIVE_RIGHT2);
	VictorSPX right3 = new VictorSPX(RobotMap.DRIVE_RIGHT3);
	
	public Drivetrain() {
		left1 = new VictorSPX(RobotMap.DRIVE_LEFT1);
		left2 = new VictorSPX(RobotMap.DRIVE_LEFT2);
		left3 = new VictorSPX(RobotMap.DRIVE_LEFT3);

		left2.follow(left1);
		left3.follow(left1);

		right1 = new VictorSPX(RobotMap.DRIVE_RIGHT1);
		right2 = new VictorSPX(RobotMap.DRIVE_RIGHT2);
		right3 = new VictorSPX(RobotMap.DRIVE_RIGHT3);

		right2.follow(right1);
		right3.follow(right1);
		right1.setInverted(true);
	}
	
	protected void initDefaultCommand(){
		setDefaultCommand(new DriveWithJoystick());
	}
	public void setMotors(double left, double right) {
		left1.set(ControlMode.PercentOutput, left);
		right1.set(ControlMode.PercentOutput, right);
	}
	public void stopMotors() {
		left1.set(ControlMode.PercentOutput, 0);
		right1.set(ControlMode.PercentOutput, 0);
	}
	
}