/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class ScoreHatch extends CommandGroup {
  /**
   * Add your docs here.
   */
  public ScoreHatch() {
    addParallel(new SetPushy(true));
    addSequential(new WaitCommand(0.2));
    addParallel(new RunHatch(-0.3));
    addSequential(new WaitCommand(0.2));
    addParallel(new RunHatch(0.0));
    addParallel(new SetPushy(false));

  }
}
