package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.kauailabs.navx.frc.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;

/**
 * @author Noah
 * Subsystem for the robot's drivetrain
 */
public class DriveTrain extends Subsystem {

    Spark leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor;
    AHRS navX;
    double leftFrontMotorThrottle, leftBackMotorThrottle, rightFrontMotorThrottle, rightBackMotorThrottle;
    
    /**
     * @author Noah
     * @param leftFrontMotorChannel
     * @param leftBackMotorChannel
     * @param rightFrontMotorChannel
     * @param rightBackMotorChannel
     * 
     * Motor channels should be set in CommandBase
     */
    public DriveTrain(int leftFrontMotorChannel, int leftBackMotorChannel, int rightFrontMotorChannel, int rightBackMotorChannel) {
    	
    	leftFrontMotor = new Spark(leftFrontMotorChannel);
    	leftBackMotor = new Spark(leftBackMotorChannel);
    	rightFrontMotor = new Spark(rightFrontMotorChannel);
    	rightBackMotor = new Spark(rightBackMotorChannel);
    	
    	leftFrontMotor.set(0);
    	leftBackMotor.set(0);
    	rightFrontMotor.set(0);
    	rightBackMotor.set(0);
    	
    	try {
    		navX = new AHRS(SPI.Port.kMXP);
    	} catch(RuntimeException ex) {
    		DriverStation.reportError("Error instantiating naxV-MXP: "+ex.getMessage(), true);
    	}
    	
    }

    public void initDefaultCommand() {
    }
    
    /**
     * @author Noah
     * @param leftFrontMotorThrottle
     * @param leftBackMotorThrottle
     * @param rightFrontMotorThrottle
     * @param rightBackMotorThrottle
     * 
     * Motor ranges: -1 to 1
     * 1 means forward -1 means backwards
     * Feed values into this method through a command
     */
    public void Drive(double forwardThrottle, double strafeThrottle, double turnThrottle) {
    	//TODO Make sure the negative signs are correct for Sidewinder and Fracture
    	
    	leftFrontMotorThrottle = forwardThrottle + turnThrottle + strafeThrottle;
        leftBackMotorThrottle = forwardThrottle + turnThrottle - strafeThrottle;
        rightFrontMotorThrottle = forwardThrottle - turnThrottle - strafeThrottle;
        rightBackMotorThrottle = forwardThrottle - turnThrottle + strafeThrottle;
    	
    	DriveBasic(leftFrontMotorThrottle, leftBackMotorThrottle, rightFrontMotorThrottle, rightBackMotorThrottle);
    	
    }
    
    public void DriveBasic(double leftFrontMotorThrottleBasic, double leftBackMotorThrottleBasic, double rightFrontMotorThrottleBasic, double rightBackMotorThrottleBasic) {
    	
    	leftFrontMotor.set(-leftFrontMotorThrottleBasic);
    	leftBackMotor.set(-leftBackMotorThrottleBasic);
    	rightFrontMotor.set(rightFrontMotorThrottleBasic);
    	rightBackMotor.set(rightBackMotorThrottleBasic);
    	
    }
   
    /**
    * @author Audrey
    * @return Yaw value between -180 and 180 degrees
    */
    public double getYaw() {
    	
    	return navX.getYaw();
    	
    }
    
    /**
     * @author Audrey
     * @return Angle between -360 and 360 degrees
     */
    public double getAngle() {
    	
    	return navX.getAngle();
    	
    }
    
}

