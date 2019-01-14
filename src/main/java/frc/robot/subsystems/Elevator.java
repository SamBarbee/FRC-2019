// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem{
	TalonSRX motor1;
	VictorSPX motor2;
	boolean m_isClosedLoop = false;
	boolean m_isZeroed = false;

  	public Elevator() {
		motor1 = new TalonSRX(RobotMap.ELEVATOR_LEFT);
		motor2 = new VictorSPX(RobotMap.ELEVATOR_RIGHT);

		motor2.follow(motor1);

		motor1.setNeutralMode(NeutralMode.Brake);
		motor2.setNeutralMode(NeutralMode.Brake);

		motor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
		motor1.setSelectedSensorPosition(0,0,0);
	}
	protected void initDefaultCommand(){
		//setDefaultCommand(new RunElevator(0.0));
	}
	public void setMotors (double power) {
		motor1.set(ControlMode.PercentOutput, power);
		motor2.set(ControlMode.PercentOutput, power);
	}
	public void ConfigClosedLoop() {
		motor1.configVoltageCompSaturation(12.0, 0);
		motor1.enableVoltageCompensation(true);

		motor1.configNominalOutputForward(0.0, 0);
		motor1.configNominalOutputReverse(0.0, 0);

		motor1.configPeakOutputForward(1.0, 0);
		motor1.configPeakOutputReverse(-0.4, 0);
		motor1.configForwardSoftLimitThreshold(Constants.ELEVATOR_SOFT_LIMIT, 0);
		
		
		motor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);
		motor1.setSensorPhase(false);

		if(!m_isZeroed) m_isZeroed = ZeroElevator();

		motor1.set(ControlMode.Position,0.0);
		motor1.configClosedloopRamp(0.10,0);

		motor1.config_kF(0, 0, 0);
		motor1.config_kP(0, Constants.ELEVATOR_P,0);
		motor1.config_kI(0, Constants.ELEVATOR_I,0);
		motor1.config_kD(0, Constants.ELEVATOR_D,0);

		m_isClosedLoop = true;
	}

	public void SetElevatorPosition(double m_position, double arb_ff) {

		if(!m_isClosedLoop) ConfigClosedLoop();

		if(m_position<1) m_position=1;

		motor1.set(ControlMode.Position, m_position, DemandType.ArbitraryFeedForward, arb_ff);
	}

	public int GetElevatorPosition() {
		return motor1.getSelectedSensorPosition();
	}
	public boolean ZeroElevator() {
		motor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

		if(motor1.getSensorCollection().isRevLimitSwitchClosed()) {
			motor1.setSelectedSensorPosition(0,0,0);
		} 
		else {
			while(!motor1.getSensorCollection().isRevLimitSwitchClosed()){
				motor1.set(ControlMode.PercentOutput,-0.1);
			}
			motor1.set(ControlMode.PercentOutput,0.0);
			motor1.setSelectedSensorPosition(0,0,0);
		}
		return true;
	}
	public boolean IsClosedLoop() {
		return m_isClosedLoop;
	}
}
