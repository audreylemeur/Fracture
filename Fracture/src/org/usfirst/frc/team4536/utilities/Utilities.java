package org.usfirst.frc.team4536.utilities;

import java.lang.Math;
import edu.wpi.first.wpilibj.Timer;

public final class Utilities {
	
	private Utilities() {} // prevent object construction which is useless. All variables and methods are static.
	
	/*------------------------------------------------Objects---------------------------------------------*/
	
	public static Timer timer = new Timer();
	
	/*-----------------------------------------------Cycle Time-------------------------------------------*/
	
	private static double currentTime, prevTime = 0.0;
	public static double cycleTime = 0.0;
	
	/*--------------------------------------------AccelerationLimit---------------------------------------*/
	
	private static double throttleDiff, accelerationLimit = 0.0;
	public static double finalThrottle = 0.0;
	
	/*------------------------------------------------methods---------------------------------------------*/
	
	/**
	 * @author Audrey
	 * @param input value to be limited.
	 * @param lowerBound minimum value input will be no greater than.
	 * @param upperBound maximum value input will be no less than.
	 * @return value after being constrained by upper and lower bounds.
	 */
	public static final double limit(double input, double lowerBound, double upperBound) {
		
		if (input < lowerBound) 
			return lowerBound;
		else if (input > upperBound)
			return upperBound;
		else 
			return input;
	}
	
	/**
	 * @author Olivia & Audrey
	 * @param input value to be limited.
	 * @param bound constrains the input value with a maximum value of bound and a minimum value of negative bound.
	 * @return value after being constrained by upper and lower bounds.
	 */
	public static final double limit(double input, double bound) {
		
		return limit(input, -bound, bound);
	}
	
	/**
	 * @author Audrey
	 * @param input value to be limited
	 * @return value after being constrained with a maximum value of 1 and a minimum value of -1.
	 */
	public static final double limit(double input) {
		
		return limit(input, 1.0);
	}
	
	/**
	 * @author Audrey
	 * @param input value to be raised to a power (or curved)
	 * @param curve exponent that the method uses to curve the input (curves smaller than 0.1 are invalid)
	 * @return input value raised an exponent (curved)
	 */
	public static final double speedCurve(double input, double curve) {
		//negative curves cause asymptotes, leading to overflow errors. Curves smaller than 0.1 aren't very useful.
		double adjustedCurve = limit(curve, 0.1, Double.MAX_VALUE);
		double adjustedInput = limit(input, 1.0);
		//if the input is negative, outputs can be undefined and positive for certain curves
		if(input < 0.0) {
			return -Math.pow(Math.abs(adjustedInput), adjustedCurve);
		}
		
		return Math.pow(adjustedInput, adjustedCurve);
	}

	/**
	 * @author Audrey
	 * @param input value that needs to be of a certain magnitude
	 * @param deadZone magnitude the input should be greater than
	 * @return input if greater than magnitude, 0 if not
	 */
	public static final double deadZone(double input, double deadZone){
	
		if((input > -deadZone) && (input < deadZone)) 
			return 0.0;
		else
			return input;
	}
	
	/**
	 *@author Audrey
	 * Starts the timer.
	 */
	public static final void startTimer() {
		
		timer.start();
		prevTime = 0.0;
	}
	
	/**
	 * @author Audrey
	 * Resets the timer by making the start time the current time so all time values are then compared to that new more recent time.
	 */
	public static final void resetTimer() {
		
		timer.reset();
		prevTime = 0.0;
	}
	
	/**
	 * @author Audrey
	 * Stops the timer.
	 */
	public static final void stopTimer() {
		
		timer.stop();
	}
	
	/**
	 * @author Audrey
	 * @return the current time of the timer in seconds.
	 */
	public static final double getTime() {
		
		return timer.get();
	}
	
	/**
	 * @author Audrey
	 * Updates the cycle time calculation of our code. This should only be called once per cycle or it will be incorrect.
	 */
	public static final void updateCycleTime() {
		
		currentTime = getTime();
		cycleTime = currentTime - prevTime;
		prevTime = currentTime;
	}
	
	/**
	 * @author Audrey
	 * @return The cycle time of our code in seconds.
	 */
	public static final double getCycleTime() {
		
		return cycleTime;
	}
	
	/**
	 * @author Audrey
	 * @param throttle - the throttle of an object.
	 * @param prevThrottle - Throttle Value from previous cycle of code.
	 * @param fullSpeedTime - The amount of time it will take the throttle to reach full speed. Range: [0, infinity+). It is a double. 
	 * @return finalThrottle - returns the throttle adjusted to be within the bounds of the acceleration limit.
	 */
	public static final double accelLimit(double throttle, double prevThrottle, double fullSpeedTime) {
		
		finalThrottle = throttle;
		
		throttleDiff = throttle - prevThrottle;

		accelerationLimit = getCycleTime() / fullSpeedTime;

		
		if (throttleDiff > accelerationLimit)
			finalThrottle = prevThrottle + accelerationLimit;
		else if (throttleDiff < -accelerationLimit)
			finalThrottle = prevThrottle - accelerationLimit;
		
		return finalThrottle;
	}
	
	/**
	 *@author Audrey
	 *@param startingAngle The angle the robot is turning from
	 *@param desiredAngle The angle the robot is turning to
	 *@return The difference between those two angles as a number from -180 to 180
	 * Example: If you want to get to 0, and your actual angle is 20, it will return
	 * -20
	 */
	public static final double angleDifference(double startingAngle, double desiredAngle){
		double difference = desiredAngle - startingAngle;
		return angleConverter(difference);
	}
	
	/**
	 * @author Theo
	 * @param ang This can be any angle.
	 * @return the inputted angle once it has been converted to a scale from -180 to 180
	 */
	public static double angleConverter(double ang){
		
		ang = ang % 360;
		if(ang > 180){
			ang = ang -360;
		}
		if(ang < -180){
			ang = ang + 360;
		}
		return(ang);
	}
	
	/**
	 * @author Theo
	 * @param ang This is the robot's original angle.(Can be between -180 and 180 degrees or 0 and 360).
	 * @param desAng This is the angle we want the robot to be facing towards or directly opposite to.
	 * @return The difference between starting angle and desired angle or the difference between starting angle and the opposite of the desired angle depending on which is smaller.
	 */
	 
	public static double shortestAngle(double ang, double desAng){

		ang = angleConverter(ang);
		desAng = angleConverter(desAng);
		double backAng = angleConverter(desAng + 180);
		double faceForward = angleConverter(desAng - ang);
		double faceBackward = angleConverter(backAng - ang);
		if(Math.abs(faceForward) <= Math.abs(faceBackward))
			return(faceForward);
		else{
			return(faceBackward);
		}
	}
	
	/**
	 * @author Audrey
	 * @param velocity The current velocity of the motor system in feet per second
	 * @param stiction The static friction of the motor system in throttle
	 * @param maxVelocity The max velocity of the motor system in feet per second
	 * @return throttle A throttle within the focused range of values which will actuate
	 */
	public static final double adjustForStiction(double velocity, double stiction, double maxVelocity) {
		
		if (velocity > -0.001 && velocity < 0.001) {
			
			return 0.0;
		}
		else {
			
			double velocityToThrottle = velocity/maxVelocity;
			
			double focusedRange = 1 - stiction;
			
			if (velocity < 0.0) {
				
				return velocityToThrottle*focusedRange - stiction;
			}
			else {
				
				return velocityToThrottle*focusedRange + stiction;
			}
		}
	}
	
	
	public static double scale(double a, double b, double scaleParam){
		
		double newA;
		
		if ((Math.abs(a) + Math.abs(b)) > scaleParam){
	
			newA = a * scaleParam/(Math.abs(a) + Math.abs(b));		
		}
		else{
		
			newA = a;
		}
		return newA;
	}
	
	
}