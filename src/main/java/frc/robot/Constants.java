/**
 * Simple class containing constants used throughout project
 */
package frc.robot;

public class Constants {
	//DRIVE
	public static final double LIMELIGHT_KP = 0.0175;
	public static final double LIMELIGHT_THRESHOLD = 1.0;
	
	//INTAKE

	//ELEVATOR
	public static final int ELEVATOR_LEVEL3 = 27000;
	public static final int ELEVATOR_LEVEL2 = 17500;
	public static final int ELEVATOR_BALL_1 = 4000;
	public static final int ELEVATOR_BALL_2 = 17000;
	public static final int ELEVATOR_BALL_3 = 30000;

	public static final int ELEVATOR_SOFT_LIMIT = 31000;

	
	public static final double ELEVATOR_P = 0.1125;//0.35;
	public static final double ELEVATOR_I = 0.0;//0.00;
	public static final double ELEVATOR_D = 0.4;//0.5;
 
	public static final double ELEVATOR_ZERO = 1.0;
	public static final double ELEVATOR_ZERO_F = -0.125;
	public static final double ELEVATOR_F = 0.07;
	public static final double ELEVATOR_F_DOWN = 0.05;
	public static final double ELEVATOR_ZERO_NEUTRAL_POSITION = 800.0;
	public static final double ELEVATOR_ZERO_NEUTRAL_POSITION_DEADBAND = 50.0;



	public static final int WRIST_UP = 200;
	public static final int WRIST_BALL = 3000;
	
	//WRIST
	public static final int WRIST_STOW = 0;
	public static final int WRIST_HATCH = 2250;

	//public static final int WRIST_SOFT_LIMIT = 3000;

	public static final int WRIST_SOFT_FWD = 3000;
	public static final int WRIST_SOFT_REV = 2000;

	public static final double WRIST_THRESHOLD = 0.15;
	public static final double WRIST_NO_IN_ELEVATOR = 750;
	public static final double WRIST_BOTTOM = 3250;
	
	public static final double WRIST_P = 0.3;
	public static final double WRIST_I = 0.00;
	public static final double WRIST_D = 0.10;


	
}