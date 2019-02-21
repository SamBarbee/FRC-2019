/**
 * Simple class containing constants used throughout project
 */
package frc.robot;

public class Constants {
	//DRIVE
	
	
	//INTAKE

	//ELEVATOR
	public static final int ELEVATOR_LEVEL3 = 19200;
	public static final int ELEVATOR_LEVEL2 = 10000;
	public static final int ELEVATOR_CARGOSHIP_BALL = 4000;

	public static final int ELEVATOR_SOFT_LIMIT = 20000;

	
	public static final double ELEVATOR_P = 0.35;
	public static final double ELEVATOR_I = 0.00;
	public static final double ELEVATOR_D = 0.5;
 
	public static final double ELEVATOR_ZERO = 1.0;
	public static final double ELEVATOR_ZERO_F = -0.15;
	public static final double ELEVATOR_F = 0.25;
	public static final double ELEVATOR_F_DOWN = 0.25;
	public static final double ELEVATOR_ZERO_NEUTRAL_POSITION = 750.0;
	public static final double ELEVATOR_ZERO_NEUTRAL_POSITION_DEADBAND = 100.0;



	//WRIST
	public static final int WRIST_STOW = 3000;
	public static final int WRIST_HATCH = 3000;
	public static final int WRIST_SHOOT = 3000;
	public static final int WRIST_PICK_BALL = 3000;
	public static final int WRIST_HATCH_FLOOR = 3000;

	public static final int WRIST_SOFT_LIMIT = 3000;

	
	public static final double WRIST_P = 0.05;
	public static final double WRIST_I = 0.00;
	public static final double WRIST_D = 0.50;

	public static final double WRIST_ZERO = 1.0;
	public static final double WRIST_ZERO_F = -0.0732;
	public static final double WRIST_F = 0.1372;
	public static final double WRIST_F_DOWN = ELEVATOR_F + 0.03;
	public static final double WRIST_ZERO_NEUTRAL_POSITION = 90.0;
	public static final double WRIST_ZERO_NEUTRAL_POSITION_DEADBAND = 60;
	
}