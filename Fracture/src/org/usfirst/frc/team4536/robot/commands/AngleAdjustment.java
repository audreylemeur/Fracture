package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.utilities.Constants;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Audrey
 */
public class AngleAdjustment extends CommandBase {

	private boolean trimRight;
	private double oldAdjustment;
	
	/** 
	 * @param inputDirection true means right / false means left
	 */
    public AngleAdjustment(boolean inputTrimRight) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	trimRight = inputTrimRight;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	oldAdjustment = driveTrain.getNavX().getAngleAdjustment();

    	if(trimRight){
    		driveTrain.getNavX().setAngleAdjustment(oldAdjustment-Constants.TRIM_STEP);
    	}else if(!trimRight){
    		driveTrain.getNavX().setAngleAdjustment(oldAdjustment+Constants.TRIM_STEP);
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
