package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4536.utilities.Utilities;

import edu.wpi.first.wpilibj.Spark;

/**
 * @author Noah
 * Subsystem for the climber
 */
public class Climber extends Subsystem {
	
	Spark motor;
	/**
	 * @author Noah
	 * @param motorPort
	 */
	public Climber(int motorPort) {
		motor = new Spark(motorPort);
	}
	
    public void initDefaultCommand() {
    }
    
    /**
     * @author Noah
     * @param input Range is from 1 to 0, negative values are not accepted
     */
    public void setClimber(double input) {
    	//Utilities.limit(input, 0, 1);
    	if (input < 0) {
    		input = 0;
    	}
    	//TODO This is temporary
    	motor.set(input);
    }
}

