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
	public static Button fieldCentric;
	
	public static Button plusDegree;
	public static Button minusDegree;

	public static double feederStationAngle;
	public static Button switchSao;
	public static Button switchPrimary;
	public static Button switchBackup;
	public static Button climb;
	
	public static Button fullSpeedClimb;
	public static Button slowClimb;

	public static Button slidePositionTop;
	public static Button slidePositionGear;
	public static Button slidePositionMiddle;
	
	public static void ButtonHandling() {
		
		holdFeeder = new JoystickButton(primaryRightStick, RobotMap.HOLD_FEEDER_BUTTON);
		holdFeeder.whenPressed(new DriveHoldAngle(feederStationAngle));
		holdFeeder.whenReleased(new Drive());
		
		holdLeft = new JoystickButton(primaryRightStick, RobotMap.HOLD_LEFT_BUTTON);
		holdLeft.whenPressed(new DriveHoldAngle(Constants.LEFT_PEG_ANGLE));
		holdLeft.whenReleased(new Drive());
		
		holdMiddle = new JoystickButton(primaryRightStick, RobotMap.HOLD_MIDDLE_BUTTON);
		holdMiddle.whenPressed(new DriveHoldAngle(Constants.MIDDLE_PEG_ANGLE));
		holdMiddle.whenReleased(new Drive());
		
		holdRight = new JoystickButton(primaryRightStick, RobotMap.HOLD_RIGHT_BUTTON);
		holdRight.whenPressed(new DriveHoldAngle(Constants.RIGHT_PEG_ANGLE));
		holdRight.whenReleased(new Drive());
		
		fieldCentric = new JoystickButton(primaryRightStick, RobotMap.HOLD_CENTER_BUTTON);

		switchBackup.whenPressed(new BackupDrive());

		fieldCentric.whenPressed(new HoldAngle(Constants.RIGHT_PEG_ANGLE));
		fieldCentric.whenReleased(new Drive());
		
		autoRotate = new JoystickButton(primaryRightStick, RobotMap.HOLD_SPECIAL_BUTTON);
		autoRotate.whenPressed(new AutoRotateDriveHoldAngle(Constants.RIGHT_PEG_ANGLE));
		autoRotate.whenReleased(new Drive());
		
		plusDegree = new JoystickButton(primaryLeftStick, RobotMap.PLUS_DEGREE_BUTTON);
		plusDegree.whenPressed(new AngleAdjustment(true));
		
		minusDegree = new JoystickButton(primaryLeftStick, RobotMap.MINUS_DEGREE_BUTTON);
		minusDegree.whenPressed(new AngleAdjustment(false));
		
    switchSao = new JoystickButton(secondaryStick, RobotMap.SAO_SWITCH);
    switchSao.whenPressed(new SaoDrive());
        
    fullSpeedClimb = new JoystickButton(secondaryStick, RobotMap.FULL_CLIMB);
    fullSpeedClimb.whenPressed(new RunClimber(1));
    fullSpeedClimb.whenReleased(new RunClimber(0));
        
		slowClimb = new JoystickButton(secondaryStick, RobotMap.SLOW_CLIMB);
		slidePositionMiddle.whenPressed(new DriveSlidePositions(Constants.MIDDLE_POSITION));
	
	}
	
	public static void setFeederStationAngle(){
		if ((DriverStation.getInstance()).getAlliance() == DriverStation.Alliance.Blue) {
			feederStationAngle = Constants.FEEDER_STATION_ANGLE;
		}
		else if ((DriverStation.getInstance()).getAlliance() == DriverStation.Alliance.Red) {
			feederStationAngle = -Constants.FEEDER_STATION_ANGLE;	
		}
	}
}
