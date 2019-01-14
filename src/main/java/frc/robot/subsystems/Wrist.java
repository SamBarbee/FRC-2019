package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Wrist extends Subsystem{
	private TalonSRX motor1;
	boolean m_isClosedLoop = false;
	boolean m_isZeroed = false;

	public Wrist() {
		motor1 = new TalonSRX(RobotMap.WRIST);

		motor1.setNeutralMode(NeutralMode.Brake);
		
		motor1.configSelectedFeedbackSensor(FeedbackDevice.Analog,0,0);
	}
	protected void initDefaultCommand(){
		
	}
	public void setMotors (double power) {
		motor1.set(ControlMode.PercentOutput, power);
	}
	public void ConfigClosedLoop() {
		motor1.configVoltageCompSaturation(12.0, 0);
		motor1.enableVoltageCompensation(true);

		motor1.configNominalOutputForward(0.0, 0);
		motor1.configNominalOutputReverse(0.0, 0);

		motor1.configPeakOutputForward(1.0, 0);
		motor1.configPeakOutputReverse(-0.4, 0);
		motor1.configForwardSoftLimitThreshold(Constants.WRIST_SOFT_LIMIT, 0);
		
		
		motor1.configSelectedFeedbackSensor(FeedbackDevice.Analog,0,0);
		motor1.setSensorPhase(false);

		motor1.set(ControlMode.Position,0.0);
		motor1.configClosedloopRamp(0.10,0);

		motor1.config_kF(0, 0, 0);
		motor1.config_kP(0, Constants.WRIST_P,0);
		motor1.config_kI(0, Constants.WRIST_I,0);
		motor1.config_kD(0, Constants.WRIST_D,0);

		m_isClosedLoop = true;
	}

	public void SetWristPosition(double m_position, double arb_ff) {

		if(!m_isClosedLoop) ConfigClosedLoop();

		if(m_position<1) m_position=1;

		motor1.set(ControlMode.Position, m_position, DemandType.ArbitraryFeedForward, arb_ff);
	}

	public int GetWristPosition() {
		return motor1.getSelectedSensorPosition();
	}
	public boolean IsClosedLoop() {
		return m_isClosedLoop;
	}
}