package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.utilities.Utilities;
import org.usfirst.frc.team4536.utilities.Constants;

/**
 * @author Noah
 * Command for making the robot drive
 */
public class BackupDrive extends CommandBase {
	
	private double forwardThrottle, strafeThrottle, turnThrottle;
	
    public BackupDrive() {
    	requires(driveTrain);
    }
    
    protected void initialize() {
    	
    	forwardThrottle = 0.0;
    	strafeThrottle = 0.0;
    	turnThrottle = 0.0;
    	
    }
    
    protected void execute() {
    	
    	forwardThrottle = Utilities.speedCurve(-OI.primaryLeftStick.getModY(), Constants.BACKUP_DRIVE_FORWARD_SPEED_CURVE);
    	strafeThrottle = Utilities.speedCurve(OI.primaryLeftStick.getModX(), Constants.BACKUP_DRIVE_STRAFE_SPEED_CURVE);
    	turnThrottle = Utilities.speedCurve(OI.primaryRightStick.getModX(), Constants.BACKUP_DRIVE_TURN_SPEED_CURVE);
    	driveTrain.Drive(forwardThrottle, strafeThrottle, turnThrottle);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
