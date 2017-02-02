package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.utilities.Constants;
import org.usfirst.frc.team4536.robot.MotionProfile;
import org.usfirst.frc.team4536.utilities.Utilities;
import edu.wpi.first.wpilibj.Timer;

public class DriveMotionProfile extends CommandBase{
	Timer timer = new Timer();
	MotionProfile prof;
	double startingAngle;
	double proportionalityConstant = Constants.FORWARD_GYRO_PROPORTIONALITY;

public DriveMotionProfile(double distance, double goalAngle, double startAngle) {
	
	this(distance, Constants.DEFAULT_SPEED, Constants.DEFAULT_ACCELERATION, goalAngle, startAngle);
}

public DriveMotionProfile(double distance, double maxSpeed, double maxAcceleration, double goalAngle, double startAngle) {

	requires(driveTrain);
	prof = new MotionProfile(distance, maxSpeed, maxAcceleration, goalAngle, startAngle);
}

public DriveMotionProfile(double distance, double maxSpeed, double maxAcceleration, double goalAngle, double startAngle, double gyroProportionality) {
	
	this(distance, maxSpeed, maxAcceleration, goalAngle, startAngle);
	proportionalityConstant = gyroProportionality;
}

/**
 * @author Liam
 * @return time in seconds since the command was started.
 */
public double getTime() {
	
	return timer.get();
}

/**
 * @author Audrey
 * @return time needed from the motion profile method.
 */
public double getNeededTime(){
	
	return prof.getTimeNeeded();
}

protected void initialize() {
	timer.reset();
	timer.start();
	
	startingAngle = driveTrain.getNavX().getAngle();
	setTimeout(prof.getTimeNeeded() + Constants.PROFILE_TIMEOUT_OFFSET);
}

protected void execute() {
	driveTrain.DriveHoldAngle(prof.getForwardThrottle(getTime()), prof.getStrafeThrottle(getTime()), prof.getDesiredAngle());
}

protected boolean isFinished() {
	return false;
}

protected void end() {
	driveTrain.DriveHoldAngle(0, 0, 0);
}
		
protected void interrupted() {
	end();
}
}
