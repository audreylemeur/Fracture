package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc.team4536.robot.commands.*;
import org.usfirst.frc.team4536.utilities.Constants;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static ModifiedJoystick primaryLeftStick = new ModifiedJoystick(RobotMap.PRIMARY_LEFT_STICK);
	public static ModifiedJoystick primaryRightStick = new ModifiedJoystick(RobotMap.PRIMARY_RIGHT_STICK);
	public static ModifiedJoystick secondaryStick = new ModifiedJoystick(RobotMap.SECONDARY_STICK);
	
	public static Button holdFeeder;
	public static Button holdLeft;
	public static Button holdMiddle;
	public static Button holdRight;
	
	public static void ButtonHandling() {
		holdFeeder = new JoystickButton(primaryLeftStick, RobotMap.HOLD_FEEDER_BUTTON);
		holdLeft = new JoystickButton(primaryLeftStick, RobotMap.HOLD_LEFT_BUTTON);
		holdMiddle = new JoystickButton(primaryLeftStick, RobotMap.HOLD_MIDDLE_BUTTON);
		holdRight = new JoystickButton(primaryLeftStick, RobotMap.HOLD_RIGHT_BUTTON);
		
		double feederStationAngle = 0.0;
		if ((DriverStation.getInstance()).getAlliance() == DriverStation.Alliance.Blue) {
			feederStationAngle = 116.6;
		}
		else if ((DriverStation.getInstance()).getAlliance() == DriverStation.Alliance.Red) {
			feederStationAngle = -116.6;	
		}
		else {
			feederStationAngle = 0.0;
		}
		holdFeeder.whenPressed(new DriveHoldAngle(feederStationAngle));
		holdLeft.whenPressed(new DriveHoldAngle(Constants.LEFT_PEG_ANGLE));
		holdMiddle.whenPressed(new DriveHoldAngle(Constants.MIDDLE_PEG_ANGLE));
		holdRight.whenPressed(new DriveHoldAngle(Constants.RIGHT_PEG_ANGLE));
		
		holdFeeder.whenReleased(new Drive());
		holdLeft.whenReleased(new Drive());
		holdMiddle.whenReleased(new Drive());
		holdRight.whenReleased(new Drive());
	}
}
