
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.RunElevator;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunWrist;

public class OI {
	private XboxController xboxController = new XboxController(RobotMap.XBOX_CONTROLLER);
	
	private Hand rightHand = Hand.kRight; //private Hand leftHand  = Hand.kLeft;
	private double leftDriverSpeed, rightDriverSpeed;
	 
	public OI() {
	
	JoystickButton upRightPad = new JoystickButton(xboxController,2);
	JoystickButton downRightPad = new JoystickButton(xboxController,4);
	
	JoystickButton upLeftPad = new JoystickButton(xboxController,1);
	JoystickButton downLeftPad = new JoystickButton(xboxController,3);
	
	JoystickButton leftBump = new JoystickButton(xboxController, 5);
	JoystickButton rightBump = new JoystickButton(xboxController, 6);

	JoystickButton povRight = new JoystickButton(xboxController, 7);
	
	//JoystickButton povUp = new JoystickButton(xboxController,9);
	
	
	rightBump.whenPressed(new RunIntake(1));
	leftBump.whenPressed(new RunIntake(-0.9));
	
	rightBump.whenReleased(new RunIntake(0));
	leftBump.whenReleased(new RunIntake(0));
	
	upRightPad.whenPressed(new RunElevator(0.65));
	downRightPad.whenPressed(new RunElevator(-0.8));
	upLeftPad.whenPressed(new RunElevator(0.3));
	downLeftPad.whenPressed(new RunElevator(-0.3));

	upRightPad.whenReleased(new RunElevator(0.0));
	downRightPad.whenReleased(new RunElevator(0.0));
	upLeftPad.whenReleased(new RunElevator(0.0));
	downLeftPad.whenReleased(new RunElevator(0.0));

	povRight.whenPressed(new RunWrist(1));

	povRight.whenReleased(new RunWrist(0));

	// povUp.whenPressed(new RunClimber(-1.0));
	// povUp.whenReleased(new RunClimber(0));
	
	
	}
	
	public double getLeftSpeed(){
		leftDriverSpeed = constrain(xboxController.getX(rightHand)-(xboxController.getY(rightHand)/Math.abs(((xboxController.getX(rightHand)/2)+Math.signum(xboxController.getY(rightHand))))));
		return Math.abs(leftDriverSpeed)>0.1?leftDriverSpeed:0;
	}
	public double getRightSpeed(){
		rightDriverSpeed = constrain(xboxController.getX(rightHand)+(xboxController.getY(rightHand)/Math.abs(((xboxController.getX(rightHand)/2)+Math.signum(xboxController.getY(rightHand))))));
		return Math.abs(rightDriverSpeed)>0.1?rightDriverSpeed:0;
	}
	private double constrain(double value){
		return Math.max(-1, Math.min(1, value));
	}
	
	
}
