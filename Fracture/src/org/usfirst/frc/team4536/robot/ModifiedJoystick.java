package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.Joystick;

public class ModifiedJoystick extends Joystick{

	public ModifiedJoystick(int port) {
		super(port);
	}
	
	public final double getModY(){
		
		return Utilities.deadZone(getY(), Constants.DEAD_ZONE);
		
	}
	
	public final double getModX(){
		
		return Utilities.deadZone(getX(), Constants.DEAD_ZONE);
		
	}
	
	public final double getModZ(){
		
		return Utilities.deadZone(getZ(), Constants.DEAD_ZONE);
		
	}

	public double getRawAxis(){
		
		return Utilities.deadZone(getRawAxis(), Constants.DEAD_ZONE);
		
	}
	
	public double getMagnitude(){
		
		return Utilities.deadZone(getMagnitude(), Constants.DEAD_ZONE);
		
	}

}
