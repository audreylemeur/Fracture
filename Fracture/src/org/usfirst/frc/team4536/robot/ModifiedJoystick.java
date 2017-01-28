package org.usfirst.frc.team4536.robot;

import org.usfirst.frc.team4536.utilities.Constants;
import org.usfirst.frc.team4536.utilities.Utilities;

import edu.wpi.first.wpilibj.Joystick;

public class ModifiedJoystick extends Joystick{

	public ModifiedJoystick(int port) {
		super(port);
	}
	
	/**
	 * @author Audrey
	 * @return Y value with deadzone
	 */
	public final double getModY(){
		
		return Utilities.deadZone(getY(), Constants.DEAD_ZONE);
		
	}
	
	/**
	 * @author Audrey
	 * @return X value with deadzone
	 */
	public final double getModX(){
		
		return Utilities.deadZone(getX(), Constants.DEAD_ZONE);
		
	}
	
	/**
	 * @author Audrey
	 * @return Z value with deadzone
	 */
	public final double getModZ(){
		
		return Utilities.deadZone(getZ(), Constants.DEAD_ZONE);
		
	}

	/**
	 * @author Audrey
	 * @param axis index starting at 0
	 * @return raw axis value with deadzone
	 */
	public double getModRawAxis(int axis){
		
		return Utilities.deadZone(getRawAxis(axis), Constants.DEAD_ZONE);
		
	}
	
	/**
	 * @author Audrey
	 * @return magnitude with deadzone
	 */
	public double getModMagnitude(){
		
		return Utilities.deadZone(getMagnitude(), Constants.DEAD_ZONE);
		
	}

}
