package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.utilities.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearScoreRedLeft extends CommandGroup {

    public GearScoreRedLeft() {
    	addSequential(new DriveMotionProfile(Constants.GEAR_LEFT_DISTANCE, Constants.GEAR_LEFT_GOAL_ANGLE, Constants.GEAR_LEFT_START_ANGLE));
        addSequential(new DriveMotionProfile(2.0, 64, 64));
		// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
