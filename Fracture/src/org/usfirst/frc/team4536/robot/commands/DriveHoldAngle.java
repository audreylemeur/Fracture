package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.utilities.NavXException;

/**
 * @author Noah
 * Class to drive robot-centric while holding an angle
 */
public class DriveHoldAngle extends CommandBase {
	
	private double forwardThrottle, strafeThrottle;
	double desiredAngle;
	
    public DriveHoldAngle(double inputAngle) {
		requires(driveTrain);
		
		desiredAngle = inputAngle;
    }
    
    protected void initialize() {
    	forwardThrottle = 0;
    	strafeThrottle = 0;
    }
    
    protected void execute() {
    	forwardThrottle = -OI.primaryLeftStick.getModY();
		  strafeThrottle = OI.primaryLeftStick.getModX();
      
    	try {
    		driveTrain.DriveHoldAngle(forwardThrottle, strafeThrottle, desiredAngle);
    	}
    	catch(NavXException e) {
    		end();
    	}
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	driveTrain.Drive(0, 0, 0);
    }
    
    protected void interrupted() {
    }
}
