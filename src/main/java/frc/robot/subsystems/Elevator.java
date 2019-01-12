// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.RunElevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem{
	TalonSRX motor1;
	VictorSPX motor2;
	public Elevator() {
		motor1 = new TalonSRX(RobotMap.ELEVATOR_LEFT);
		motor2 = new VictorSPX(RobotMap.ELEVATOR_RIGHT);
	}
	protected void initDefaultCommand(){
		setDefaultCommand(new RunElevator(0.0));
	}
	public void setMotors (double power) {
		motor1.set(ControlMode.PercentOutput, power);
		motor2.set(ControlMode.PercentOutput, power);
	}
}
