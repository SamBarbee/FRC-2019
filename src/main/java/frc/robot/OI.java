/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// package frc.robot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
// public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
// }

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.RunElevator;

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
	
	JoystickButton povUp = new JoystickButton(xboxController,9);
	
	
	// rightBump.whenPressed(new RunIntake(1));
	// leftBump.whenPressed(new RunIntake(-0.9));
	
	// rightBump.whenReleased(new RunIntake(0));
	// leftBump.whenReleased(new RunIntake(0));
	
	upRightPad.whenPressed(new RunElevator(0.65));
	downRightPad.whenPressed(new RunElevator(-0.8));
	upLeftPad.whenPressed(new RunElevator(0.3));
	downLeftPad.whenPressed(new RunElevator(-0.3));

	upRightPad.whenReleased(new RunElevator(0.0));
	downRightPad.whenReleased(new RunElevator(0.0));
	upLeftPad.whenReleased(new RunElevator(0.0));
	downLeftPad.whenReleased(new RunElevator(0.0));
	
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
