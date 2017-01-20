package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

/**
 * @author Noah
 * Command for making the robot drive
 */
public class Drive extends CommandBase {
	
	private static double forwardThrottle, strafeThrottle, turnThrottle;
	double leftFrontMotorThrottle, leftBackMotorThrottle, rightFrontMotorThrottle, rightBackMotorThrottle;
	
    public Drive() {
    	requires(driveTrain);
    }
    
    protected void initialize() {
    	
    	forwardThrottle = 0;
    	strafeThrottle = 0;
    	turnThrottle = 0;
    	
    }
    
    protected void execute() {
    	
    	forwardThrottle = Utilities.deadZone(-OI.primaryStick.getY(), Constants.DEAD_ZONE);
		strafeThrottle = Utilities.deadZone(OI.primaryStick.getX(), Constants.DEAD_ZONE);
		
    	turnThrottle = Utilities.deadZone(OI.secondaryStick.getX(), Constants.DEAD_ZONE);
    	
    	leftFrontMotorThrottle = forwardThrottle + turnThrottle + strafeThrottle;
        leftBackMotorThrottle = forwardThrottle + turnThrottle - strafeThrottle;
        rightFrontMotorThrottle = forwardThrottle - turnThrottle - strafeThrottle;
        rightBackMotorThrottle = forwardThrottle - turnThrottle + strafeThrottle;
    	
    	driveTrain.Drive(leftFrontMotorThrottle, leftBackMotorThrottle, rightFrontMotorThrottle, rightBackMotorThrottle);
    	
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
