package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.MotionProfile;

import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.utilities.*;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * @author Noah
 * Command for putting things on the smart dash board
 */
public class SmartDashboardCommand extends CommandBase {
	
	EnhancedTimer timer;
	double time;
	SendableChooser team;
	
    public SmartDashboardCommand() {
    	timer = new EnhancedTimer();
    	
    	team = new SendableChooser();
    	team.addDefault("Red", 0);
    	team.addObject("Blue", 1);
    	SmartDashboard.putData("Team Chooser", team);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.resetTimer();
    	timer.startTimer();
    	
    	
    	//OI.feederStationAngle = -Constants.FEEDER_STATION_ANGLE;
    	
    	switch ((int) team.getSelected().hashCode()) {
		case 1:
			OI.feederStationAngle = Constants.BLUE_FEEDER_STATION_ANGLE;
		break;
		default:
			OI.feederStationAngle = Constants.RED_FEEDER_STATION_ANGLE;
		break;
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    
    /**
     * @author Eddie
     * displays values in the Smart Dashboard
     */
    
    protected void execute() {
    	
    	switch ((int) team.getSelected().hashCode()) {
		case 1:
			OI.feederStationAngle = Constants.BLUE_FEEDER_STATION_ANGLE;
		break;
		default:
			OI.feederStationAngle = Constants.RED_FEEDER_STATION_ANGLE;
		break;
    	}
    	
    	time = timer.getTime();
    	
    	//NavX
    	try {
    		
    		SmartDashboard.putNumber("Adjusted Angle: ", driveTrain.getNavX().getAngle());
        	SmartDashboard.putNumber("Yaw: ", driveTrain.getNavX().getYaw());
        	SmartDashboard.putNumber("Pitch: ", driveTrain.getNavX().getPitch());
        	SmartDashboard.putNumber("Roll: ", driveTrain.getNavX().getRoll());
    		
    	}
    	catch(NavXException e) {
    	}
    	
    	//Joysticks
    	SmartDashboard.putNumber("Right Joystick Y: ", OI.primaryRightStick.getY());		
    	SmartDashboard.putNumber("Right Joystick X: ", OI.primaryRightStick.getX());		
    	SmartDashboard.putNumber("Secondary Joystick Y: ", OI.secondaryStick.getY());		
    	SmartDashboard.putNumber("Secondary Joystick X: ", OI.secondaryStick.getX());		
    	SmartDashboard.putNumber("Left Joystick Y: ", OI.primaryLeftStick.getY());		
    	SmartDashboard.putNumber("Left Joystick X: ", OI.primaryLeftStick.getX());
    	
    	//TESTS
    	SmartDashboard.putNumber("Last Desired Angle", driveTrain.getLastDesiredAngle());
    	SmartDashboard.putNumber("Joystick Angle", OI.primaryRightStick.getDirectionDegrees());
    	
    	//Encoders
    	try {
    	SmartDashboard.putNumber("Forward Encoder", driveTrain.getForwardEncoder(0));
    	SmartDashboard.putNumber("Forward Encoder Rate", driveTrain.getForwardRate(0));
    	SmartDashboard.putNumber("Strafe Encoder", driveTrain.getStrafeEncoder(0));
    	SmartDashboard.putNumber("Strafe Encoder Rate", driveTrain.getStrafeRate(0));
    	}
    	catch(EncoderException e) {
    	}
    	
    	SmartDashboard.putBoolean("Collision:", driveTrain.checkForCollision());
    	SmartDashboard.putNumber("Jerk", driveTrain.getJerk());
    	
    	SmartDashboard.putData(driveTrain);
    }

	// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	timer.stopTimer();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
