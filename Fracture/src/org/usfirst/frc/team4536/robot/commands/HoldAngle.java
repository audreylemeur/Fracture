package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.utilities.Constants;

/**
 *@author Theo
 *Class to drive while holding an angle, field-centric.
 */
public class HoldAngle extends CommandBase {
	private double forwardThrottle, strafeThrottle, rAng;

    public HoldAngle(double robotAngle) {
        requires(driveTrain);
        rAng = robotAngle;
    }

    protected void initialize() {
    	forwardThrottle = 0;
    	strafeThrottle = 0;
    	//Keep the robot from spazzing out.
    }

    protected void execute() {
    	forwardThrottle = Math.cos(Math.toRadians(driveTrain.getNavX().getAngle() - OI.primaryLeftStick.getDirectionDegrees())) * -OI.primaryLeftStick.getModMagnitude();
    	strafeThrottle = Math.sin(Math.toRadians(driveTrain.getNavX().getAngle() - OI.primaryLeftStick.getDirectionDegrees())) * Constants.FORWARD_STRAFE_RATIO * OI.primaryLeftStick.getModMagnitude();
    	
    	driveTrain.Drive(forwardThrottle, strafeThrottle, 0);
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
    }
}
