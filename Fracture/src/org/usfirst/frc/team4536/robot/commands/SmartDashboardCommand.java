package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4536.robot.OI;


/**
 *
 */
public class SmartDashboardCommand extends CommandBase {
	
	 
    
	public SmartDashboardCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	/*SmartDashboard.putNumber("Turn Rate in Degrees per Second: ", driveTrain.getYaw());
    	SmartDashboard.putNumber("Pitch: ", driveTrain.getNavXPitch());
    	SmartDashboard.putNumber("Roll: ", driveTrain.getNavXRoll());*/
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Primary Joystick Y: ", OI.primaryLeftStick.getY());
		SmartDashboard.putNumber("Primary Joystick X: ", OI.primaryLeftStick.getX());
		SmartDashboard.putNumber("Secondary Joystick Y: ", OI.secondaryStick.getY());
		SmartDashboard.putNumber("Secondary Joystick X: ", OI.secondaryStick.getX());
		SmartDashboard.putNumber("Tertiary Joystick Y: ", OI.primaryRightStick.getY());
		SmartDashboard.putNumber("Tertiary Joystick X: ", OI.primaryRightStick.getX());
		SmartDashboard.putNumber("Turn Rate in Degrees per Second: ", driveTrain.getYaw());
    	SmartDashboard.putNumber("Pitch: ", driveTrain.getNavXPitch());
    	SmartDashboard.putNumber("Roll: ", driveTrain.getNavXRoll());
    	//SmartDashboard.putNumber("Time: ", EnhancedTimer.getTime());
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
