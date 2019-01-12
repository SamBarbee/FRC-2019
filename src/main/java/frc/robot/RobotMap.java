/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
// public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
// }

package frc.robot;

public class RobotMap {
	public static final int PDP_ID = 0;
	public static final int XBOX_CONTROLLER = 0;
	
	public static final int DRIVE_LEFT1 = 1;
	public static final int DRIVE_LEFT2 = 2;
	public static final int DRIVE_RIGHT1 = 8;
	public static final int DRIVE_RIGHT2 = 7;
	
	public static final int INTAKE_LEFT = 4;
	public static final int INTAKE_RIGHT = 5;
	
	public static final int LIFT_LEFT = 6;
	public static final int LIFT_RIGHT = 3;
	
	public static int pidgeyAddress = 9;
	
	public static double driveF = 0.5;
	public static double driveP = 0.6;
	public static double driveI = 0.0;
	public static double driveD = 0.3;
	
	public static double gyroP = 0.2;
	public static double gyroI = 0.0;
	public static double gyroD = 0.01;
	
	public static int talonTimeoutMs = 10;
	public static int talonCruise = 500;
	public static int talonAccel = 1500;
	
	//public static int RightSidePID = 0;
	//public static int LeftSidePID = 1;
	
	public static final int DrivePID = 0;
	
	public static double wheelDiameter = 6;
	
	public static double autoLineDist = 11*12;
}
