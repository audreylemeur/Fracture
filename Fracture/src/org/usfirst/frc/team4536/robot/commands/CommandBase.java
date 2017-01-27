package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.subsystems.*;

/**
 * @author Noah
 * Class for creating subsystems for use in commands, all commands should extend CommandBase
 */
public class CommandBase extends Command {
	
	public static DriveTrain driveTrain = new DriveTrain(RobotMap.LEFT_FRONT_MOTOR, RobotMap.LEFT_BACK_MOTOR, RobotMap.RIGHT_FRONT_MOTOR, RobotMap.RIGHT_BACK_MOTOR);
	private double forwardThrottle;
	
    public CommandBase() {
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
