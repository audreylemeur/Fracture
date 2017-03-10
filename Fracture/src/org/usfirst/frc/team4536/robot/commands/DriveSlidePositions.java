package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.utilities.Constants;
import org.usfirst.frc.team4536.utilities.NavXException;
/**
 *@author Eddie
 *Command to rotate the gear slide
 */

public class DriveSlidePositions extends CommandBase {
	public double position;
    public DriveSlidePositions(double pos) {
    	requires(gearSlide);
    	position = pos;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    public DriveSlidePositions() {
    	requires(gearSlide);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	try{
    		
    		if(driveTrain.getNavX().getRoll()>Constants.OFF_GROUND_ANGLE){
 
    	    	gearSlide.setGearSlide(Constants.LOWER_LIMIT);
            	
            }else 
            	gearSlide.setGearSlide(position);
            
    	}catch(NavXException e) {
    		
    		;
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
