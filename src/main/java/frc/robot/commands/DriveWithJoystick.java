package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Limelight;


import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoystick extends Command {

	double l,r,oldTx;

	public DriveWithJoystick() {
		requires(Robot.drivetrain);
	}
	@Override
	protected void initialize() {
	}
	public void execute() {
		l = Robot.OI.getLeftSpeed(); r = Robot.OI.getRightSpeed();

		// if(Robot.OI.trackAllowed()) {
		// 	//Robot.limelight.setLedMode(Limelight.LED_ON);

		// 	if(Robot.limelight.getTx() > Constants.LIMELIGHT_THRESHOLD || Robot.limelight.getTx() < -Constants.LIMELIGHT_THRESHOLD) {
		// 		l +=  (Robot.limelight.getTx() * Constants.LIMELIGHT_KP) + ((Robot.limelight.getTx()-oldTx)*Constants.LIMELIGHT_KD);
		// 		r -=  (Robot.limelight.getTx() * Constants.LIMELIGHT_KP) + ((Robot.limelight.getTx()-oldTx)*Constants.LIMELIGHT_KD);

		// 		oldTx = Robot.limelight.getTx();
		// 	}
		// }
		// // else if(Robot.OI.flashyBoi()) {
		// // 	Robot.limelight.setLedMode(Limelight.LED_BLINK);
		// // }
		// else {
		// 	Robot.limelight.setLedMode(Limelight.LED_OFF);
		// }

		Robot.drivetrain.setMotors(l, r);
	}
	protected boolean isFinished() {
		return false;
	}
	protected void end() {
		Robot.drivetrain.setMotors(0, 0);
	}
	protected void interrupted() {
		Robot.drivetrain.setMotors(0, 0);
	}
} 