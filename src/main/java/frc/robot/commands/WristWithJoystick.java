package frc.robot.commands;

import frc.robot.commands.WristJointGroup;

import java.lang.Math;

import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.Robot;

// import org.graalvm.compiler.core.common.type.ArithmeticOpTable.UnaryOp.Abs;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.StartCommand;



public class WristWithJoystick extends Command {
	boolean isIntakeHeld,wantIntakeHold,passGo=false;
	double wristSpeed;

	public WristWithJoystick() {
		requires(Robot.wrist);
	}
	@Override
	protected void initialize() {
		isIntakeHeld = false;

	}
	public void execute() {

		wristSpeed = Robot.OI.getWristSpeed();

		if(wristSpeed >= 0.3)
		{
			Robot.hatchroller.setPush(false);
			Robot.wrist.SetWristPosition(Constants.WRIST_BALL);
		}
		else if(wristSpeed <= -0.3)
		{
			Robot.hatchroller.setPush(false);
			Robot.wrist.SetWristPosition(Constants.WRIST_UP);
		}

		// if(Robot.wrist.GetWristPosition()>Constants.WRIST_NO_IN_ELEVATOR) {
		// 	passGo = true;
		// }

		// if(Robot.wrist.GetWristPosition()<Constants.WRIST_NO_IN_ELEVATOR && wristSpeed < Constants.WRIST_THRESHOLD && !passGo) {
		// 	wristSpeed = 0.0;
		// }
		// else if(Robot.wrist.GetWristPosition()<Constants.WRIST_NO_IN_ELEVATOR && wristSpeed < Constants.WRIST_THRESHOLD && passGo) {
		// 	Robot.wrist.SetWristPosition(Constants.WRIST_NO_IN_ELEVATOR);
		// }

		// if(Robot.wrist.GetWristPosition()>Constants.WRIST_BOTTOM) {
		// 	Robot.wrist.SetWristPosition(Constants.WRIST_BOTTOM);
		// }

		// if(Math.abs(Robot.OI.getWristSpeed()) > Constants.WRIST_THRESHOLD)
		// {
		// 	isIntakeHeld = false;
		// 	Robot.wrist.setMotors(wristSpeed);

		// }
		// if((Math.abs(Robot.OI.getWristSpeed()) <= Constants.WRIST_THRESHOLD && isIntakeHeld == false) || wantIntakeHold) {
		// 	isIntakeHeld = true;
		// 	Robot.wrist.SetWristPosition(Robot.wrist.GetWristPosition());
		// }
		// if(Robot.OI.leftJoystickButton.get()) {
		// 	isIntakeHeld = true;
		// 	Robot.wrist.SetWristPosition(Constants.WRIST_HATCH);
		// }

		///////////////////////////////////////////





	}
	protected boolean isFinished() {
		return false;
	}
	protected void end() {
		Robot.wrist.setMotors(0);
	}
	protected void interrupted() {
		Robot.wrist.setMotors(0);
	}
} 