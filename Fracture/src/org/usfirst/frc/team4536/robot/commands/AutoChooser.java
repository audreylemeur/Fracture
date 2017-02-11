package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.utilities.NavXException;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Noah
 * Command for choosing an auto mode
 */
public class AutoChooser extends CommandBase {
	
	SendableChooser autoChooser;

    public AutoChooser() {
    	autoChooser = new SendableChooser();
    	
    	autoChooser.addDefault(" Do Nothing", 0);
    	autoChooser.addObject(" Cross Baseline", 1);
    	/* TODO These will be added in as we make more auto modes.
    	autoChooser.addObject(" Score Gear Left",  2);
    	autoChooser.addObject(" Score Gear Middle", 3);
    	autoChooser.addObject(" Score Gear Right", 4);
    	*/
    	SmartDashboard.putData(" Auto Chooser", autoChooser);
    }
    
    public void setInitialAngle(double input) {
    	try {
    	driveTrain.getNavX().setAngleAdjustment(input);
    	}
    	catch(NavXException e){
    		end();
    	}
    }
    
    protected void initialize() {
    	switch ((int) autoChooser.getSelected().hashCode()) {
    		case 1:
    			setInitialAngle(0.0);
    			new CrossBaseline().start();
    		break;
    		default:
    			setInitialAngle(0.0);
    			new DoNothing().start();
    		break;
    	}
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
