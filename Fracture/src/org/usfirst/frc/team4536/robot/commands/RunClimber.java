package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;

/**
 * @author Noah
 * Command to run the climber with a joystick
 */
public class RunClimber extends CommandBase {

    public RunClimber() {
        requires(climber);
    }
    
    protected void initialize() {
    	climber.setClimber(0);
    }
    
    protected void execute() {
    	climber.setClimber(-OI.secondaryStick.getModY());
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	climber.setClimber(0);
    }
    
    protected void interrupted() {
    	end();
    }
}
