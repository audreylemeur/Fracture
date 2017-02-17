package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.utilities.NavXException;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OffGround extends CommandBase {

    public OffGround() {
        
    	requires(climber);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	try{
        if(driveTrain.getNavX().getPitch()>80 && driveTrain.getNavX().getPitch()<-280){
        	
        	return true;
        	
        }else return false;
    	}catch(NavXException e) {
    		
    		return true;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
