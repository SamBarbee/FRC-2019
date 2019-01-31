package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

import frc.robot.OI;
import frc.robot.subsystems.*;
import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.commands.*;

public class Robot extends TimedRobot {
	//Subsystems
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Intake intake = new Intake();
	public static final Elevator elevator = new Elevator();
	public static final Wrist wrist = new Wrist(); 
	public static final OI OI = new OI();

	@Override
	public void robotInit() {
		//CameraServer.getInstance().startAutomaticCapture();
	};
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		if (!elevator.IsClosedLoop()){
			elevator.ConfigClosedLoop();
		}

	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (!elevator.IsClosedLoop()){
			elevator.ConfigClosedLoop();
		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		System.out.println(elevator.GetElevatorPosition());

		if(OI.getPOVangle()==0) {Scheduler.getInstance().add(new SetWrist(Constants.WRIST_STOW));}
		if(OI.getPOVangle()==90) {Scheduler.getInstance().add(new SetWrist(Constants.WRIST_HATCH));}
		if(OI.getPOVangle()==180) {Scheduler.getInstance().add(new SetWrist(Constants.WRIST_SHOOT));}
		if(OI.getPOVangle()==270) {Scheduler.getInstance().add(new SetWrist(Constants.WRIST_PICK_BALL));}
	}

	@Override
	public void testPeriodic() {
	}
}
