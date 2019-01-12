// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.OI;
import frc.robot.commands.autonomous.DynamicAuton;
// import frc.robot.commands.autonomous.AutoLineAuto;
// import frc.robot.commands.autonomous.Center2Cube;
// import frc.robot.commands.autonomous.ScoreSideLeft;
// import frc.robot.commands.autonomous.ScoreSideRight;
// import frc.robot.commands.autonomous.SwitchScoreLeft;
// import frc.robot.commands.autonomous.SwitchScoreRight;
import frc.robot.commands.drive.*;
import frc.robot.subsystems.*;
import frc.robot.subsystems.drive.Drivetrain;
import edu.wpi.first.wpilibj.CameraServer;

public class Robot extends TimedRobot {
	//Subsystems
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Intake intake = new Intake();
	public static final Elevator elevator = new Elevator();
	public static final OI OI = new OI();

	public static enum Side {left,right,center};
	
	Command AutonomousCommand;
	SendableChooser<DynamicAuton> AutonomousChooser = new SendableChooser<>();
	
	public static String gameData;

	@Override
	public void robotInit() {
		AutonomousChooser.addDefault("Auto Disabled", null);
		// AutonomousChooser.addObject("Autoline", new AutoLineAuto());
		// AutonomousChooser.addObject("Score Switch - Left Start", new SwitchScoreLeft());
		// AutonomousChooser.addObject("Score Switch - Right Start", new SwitchScoreRight());
		// AutonomousChooser.addObject("ScoreSide - Right", new ScoreSideLeft());
		// AutonomousChooser.addObject("ScoreSide - Left", new ScoreSideRight());
		// AutonomousChooser.addObject("Danktester", new Center2Cube());
		//SmartDashboard.putData("Auto mode", AutonomousChooser);
		
		CameraServer.getInstance().startAutomaticCapture();
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
		DynamicAuton builder = AutonomousChooser.getSelected();
		 
		if (builder != null) {
			AutonomousCommand = builder.build();
			AutonomousCommand.start();
		}
	}
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (AutonomousCommand != null) {
			AutonomousCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
