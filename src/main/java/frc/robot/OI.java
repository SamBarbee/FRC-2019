
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.SetElevator;
import frc.robot.commands.RunHatch;
import frc.robot.commands.SetWrist;

public class OI {
	private XboxController xboxController = new XboxController(RobotMap.XBOX_CONTROLLER);
	
	private Hand rightHand = Hand.kRight; private Hand leftHand  = Hand.kLeft;
	private double leftDriverSpeed, rightDriverSpeed,wristSpeed,ballSpeed;

	JoystickButton upRightPad;
	JoystickButton downRightPad;
	JoystickButton upLeftPad;
	JoystickButton downLeftPad;
	JoystickButton leftBump;
	JoystickButton rightBump;
	JoystickButton startButton;
	JoystickButton menuButton;
	JoystickButton leftJoystickButton;
	JoystickButton rightJoystickButton;

	public OI() {
	
		upRightPad = new JoystickButton(xboxController,2);
		downRightPad = new JoystickButton(xboxController,4);
		upLeftPad = new JoystickButton(xboxController,1);
		downLeftPad = new JoystickButton(xboxController,3);
		
		leftBump = new JoystickButton(xboxController, 5);
		rightBump = new JoystickButton(xboxController, 6);

		startButton = new JoystickButton(xboxController, 7);
		menuButton = new JoystickButton(xboxController, 8);

		leftJoystickButton = new JoystickButton(xboxController, 9);
		rightJoystickButton = new JoystickButton(xboxController, 10);
		
		
		leftJoystickButton.whenPressed(new SetWrist(0.0));

		rightBump.whenPressed(new RunHatch(1.0));
		leftBump.whenPressed(new RunHatch(-0.5));
		menuButton.whenPressed(new RunHatch(-0.3));
		
		
		menuButton.whenReleased(new RunHatch(0.0));
		rightBump.whenReleased(new RunHatch(0.0));
		leftBump.whenReleased(new RunHatch(0.0));
		
		upRightPad.whenPressed(new SetElevator(Constants.ELEVATOR_LEVEL2));
		downRightPad.whenPressed(new SetElevator(Constants.ELEVATOR_LEVEL3));
		upLeftPad.whenPressed(new SetElevator(Constants.ELEVATOR_CARGOSHIP_BALL));
		downLeftPad.whenPressed(new SetElevator(Constants.ELEVATOR_ZERO));
		
	}
	
	public double getPOVangle() {
		return xboxController.getPOV();
	}

	
	public double getBallSpeed(){
		ballSpeed = xboxController.getTriggerAxis(leftHand)-xboxController.getTriggerAxis(rightHand);
		return ballSpeed;
	}
	public double getWristSpeed(){
		wristSpeed= xboxController.getY(leftHand);
		return wristSpeed;
	}
	public double getLeftSpeed(){
		leftDriverSpeed = constrain(xboxController.getX(rightHand)-(xboxController.getY(rightHand)/Math.abs(((xboxController.getX(rightHand)/2)+Math.signum(xboxController.getY(rightHand))))));
		return Math.abs(leftDriverSpeed)>0.15?leftDriverSpeed:0;
	}
	public double getRightSpeed(){
		rightDriverSpeed = constrain(xboxController.getX(rightHand)+(xboxController.getY(rightHand)/Math.abs(((xboxController.getX(rightHand)/2)+Math.signum(xboxController.getY(rightHand))))));
		return Math.abs(rightDriverSpeed)>0.15?rightDriverSpeed:0;
	}
	private double constrain(double value){
		return Math.max(-1, Math.min(1, value));
	}
	
	
}
