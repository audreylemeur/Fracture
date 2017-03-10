package org.usfirst.frc.team4536.utilities;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Constants {
  
	//Utilities
	
	public static final double DEAD_ZONE = 0.08;
	public static final double FORWARD_SPEED_CURVE = 0.0;
	public static final double TURN_SPEED_CURVE = 0.0;
	public static final double STRAFE_SPEED_CURVE = 0.0;
	public static final double SCALE_PARAM = 0.7; //TODO this needs fine tuning
	public static final double FORWARD_STICTION = 0.17;
	public static final double STRAFE_STICTION = 0.22;
	public static final double DRIVE_TRAIN_MAX_VELOCITY = 13.0; //TODO IDK what value this should be
	
	//Camera

	public static final int CAMERA_RESOLUTION_WIDTH = 200;
	public static final int CAMERA_RESOLUTION_HEIGHT = 150;
	
	//Drive Train
  
	public static final double AUTO_HOLD_ANGLE_P_CONSTANT = 0.05; //Throttle per degree
	public static final double FORWARD_STRAFE_RATIO = 3.0; //Ratio of forward velocity to strafing velocity
	public static final double DRIVE_TRAIN_ACCEL_LIMIT = 0.1; //In seconds

	public static final double BACKUP_DRIVE_STRAFE_SPEED_CURVE = 0.8;
	public static final double BACKUP_DRIVE_TURN_SPEED_CURVE = 2.0;
	public static final double BACKUP_DRIVE_FORWARD_SPEED_CURVE = 2.0;

	public static final double CROSS_BASELINE_SPEED = 0.5;
  
	public static final double CROSS_BASELINE_RUN_TIME = 2.0;
	public static final double CROSS_BASELINE_TIMEOUT = 5.0;

	public static final double COLLISION_DETECTION_THRESHOLD = 2.0;
	
	public static enum PEG_POSITION {LEFT_PEG, MIDDLE_PEG, RIGHT_PEG};

	//OI
	
	public static final double BLUE_FEEDER_STATION_ANGLE = -116.6;
	public static final double RED_FEEDER_STATION_ANGLE = 116.6;
	public static final double LEFT_PEG_ANGLE = 60.0;
	public static final double MIDDLE_PEG_ANGLE = 0.0;
	public static final double RIGHT_PEG_ANGLE = -60.0;
	
	//Profile constants
	//These might need changing, they're mostly just copied from last year.

	public static final double DEFAULT_SPEED = 2.0; //Measured in meters per second.
	public static final double DEFAULT_ACCELERATION = 4.0; //Measured in meters per second squared.
	public static final double PROFILE_TIMEOUT_OFFSET = 0.5; //Measured in seconds. Gives the motion profile a bit of extra time to do what it needs.

	public static final double DRIVE_ENCODER_PROPORTIONALITY_CONSTANT_STRAFE = 175.0; //Ticks per inch
	public static final double DRIVE_ENCODER_PROPORTIONALITY_CONSTANT_FORWARD = 141.0; //Ticks per inch

    
	//Angle Adjustments
	
	public static final double TRIM_STEP = 3.0;
    
	//Sao Drive (These need to be modified to fit needs)
    
	public static final double SAO_FORWARD_CURVE = 2.0;
	public static final double SAO_STRAFE_CURVE = 2.0;
	public static final double SAO_FORWARD_MAX_SPEED = .50;
	public static final double SAO_STRAFE_MAX_SPEED = .70;
	
	//Field centric

	public static final double FIELD_FORWARD_SCALE = 0.80; //throttle
	public static final double FIELD_STRAFE_SCALE = 0.80; //throttle
	public static final double FIELD_P_CONSTANT = 0.02; 
	public static final double FIELD_SCALE_PARAM = 0.70; //unitless
	public static final double FIELD_SPEED_CURVE = 1.0; //unitless
	
	//Field Centric auto-rotate
	
	public static final double AUTO_ROTATE_P_CONSTANT = 0.01;
	public static final double AUTO_ROTATE_SCALE_PARAM = 0.7;
	public static final double AUTO_ROTATE_SPEED_CURVE = 2.0;
	
	//Tank Field Centric auto-rotate
	
	public static final double TANK_ROTATE_P_CONSTANT = 0.01;
	public static final double TANK_ROTATE_SCALE_PARAM = 0.5;
	public static final double TANK_ROTATE_SPEED_CURVE = 2.0;

	//Field Centric Rotate
	
	public static final double ROTATE_P_CONSTANT = 0.02;
	public static final double ROTATE_SCALE_PARAM = 0.70; //unitless
	public static final double ROTATE_SPEED_CURVE = 1.0; //unitless
	public static final double ROTATE_RIGHT_THROTTLE = 0.40; //throttle
	public static final double ROTATE_LEFT_THROTTLE = -0.40; //throttle

	// HoldAngle
	
	public static final double HOLD_ANGLE_P_CONSTANT = 0.02; //Throttle per degree
	public static final double HOLD_ANGLE_SCALE_PARAM = 0.6;
	public static final double HOLD_ANGLE_SPEED_CURVE = 1.0; //unitless
	
	//Climb 
	

	public static final double SLOW_CLIMB_SPEED = 0.50; //between 0 and 1
	public static final double CLIMB_ACCEL_LIMIT = 0.10;
	public static final double OFF_GROUND_ANGLE = 30; //roll degrees (pitch on sidewinder)
	public static final double OFF_GROUND_TIME = 0.25; //seconds
	
	//Gear Slide
	
	public static final double TOP_POSITION = 0.65;
	public static final double GEAR_POSITION = 0.30;
	public static final double MIDDLE_POSITION = 0.48;//TODO tweak later
	public static final double UPPER_LIMIT = 0.65;
	public static final double LOWER_LIMIT = 0.29;

	//Score Gear Left
	
	public static final double GEAR_LEFT_DISTANCE = 6.0;//8.0; //feet
	public static final double GEAR_LEFT_GOAL_ANGLE = 23.0; //degrees
	public static final double GEAR_LEFT_START_ANGLE = 64.0; //degrees
	
	//Score Gear Middle
  
	public static final double GEAR_MIDDLE_DISTANCE = 8.0; //feet
	public static final double GEAR_MIDDLE_GOAL_ANGLE = 0.0; //degrees
	public static final double GEAR_MIDDLE_START_ANGLE = 0.0; //degrees
	
	//Score Gear Right
	
	public static final double GEAR_RIGHT_DISTANCE = 10.0; //feet
	public static final double GEAR_RIGHT_GOAL_ANGLE = -40.0; //degrees
	public static final double GEAR_RIGHT_START_ANGLE = -60.0; //degrees
}
