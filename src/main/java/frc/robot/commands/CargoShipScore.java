/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CargoShipScore extends CommandGroup {
  /**
   * Add your docs here.
   */
  public CargoShipScore() {
    addParallel(new SetElevator(Constants.ELEVATOR_BALL_CARGO));
    addParallel(new SetWrist(Constants.WRIST_CARGOSHIP));
  }
}
