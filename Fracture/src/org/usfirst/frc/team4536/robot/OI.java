package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static Joystick primaryStick;
	public static Joystick secondaryStick;
	
	public OI() {
		primaryStick = new Joystick(RobotMap.PRIMARY_STICK);
		secondaryStick = new Joystick(RobotMap.SECONDARY_STICK);
	}
}
