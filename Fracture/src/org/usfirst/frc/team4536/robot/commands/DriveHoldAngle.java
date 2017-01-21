package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

/**
 * @author Noah
 * Class to drive robot-centric while holding an angle
 */
public class DriveHoldAngle extends CommandBase {
	
	private double forwardThrottle, strafeThrottle;
	double desiredAngle = 0;
	
    public DriveHoldAngle() {
		requires(driveTrain);
    }
    
    protected void initialize() {
    	forwardThrottle = 0;
    	strafeThrottle = 0;
    }
    
    protected void execute() {
    	
    	forwardThrottle = Utilities.deadZone(-OI.primaryStick.getY(), Constants.DEAD_ZONE);
		strafeThrottle = Utilities.deadZone(OI.primaryStick.getX(), Constants.DEAD_ZONE);
		
		driveTrain.DriveHoldAngle(forwardThrottle, strafeThrottle, desiredAngle);
    	
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
