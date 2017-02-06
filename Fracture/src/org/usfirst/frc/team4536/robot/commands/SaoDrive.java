package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.utilities.Constants;
import org.usfirst.frc.team4536.utilities.Utilities;

/**
 * @author Audreys
 * Class to drive robot-centric while holding an angle
 * Also uses constants specific to Sao
 */
public class SaoDrive extends CommandBase {
	
	private double forwardThrottle, strafeThrottle;
	double desiredAngle;
	
    public SaoDrive() {
		requires(driveTrain);
		
		desiredAngle = driveTrain.getLastDesiredAngle();
    }
    
    protected void initialize() {
    	forwardThrottle = 0;
    	strafeThrottle = 0;
    }
    
    protected void execute() {
    	
    	forwardThrottle = -OI.secondaryStick.getModY();
		strafeThrottle = OI.secondaryStick.getModX();
		
		forwardThrottle = Utilities.speedCurve(forwardThrottle, Constants.SAO_FORWARD_CURVE);
		strafeThrottle = Utilities.speedCurve(strafeThrottle, Constants.SAO_STRAFE_CURVE);
		
		forwardThrottle = forwardThrottle*Constants.SAO_FORWARD_MAX_SPEED;
		strafeThrottle = forwardThrottle*Constants.SAO_STRAFE_MAX_SPEED;
		
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
