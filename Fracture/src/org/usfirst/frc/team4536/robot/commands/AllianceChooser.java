package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.utilities.Constants;
import org.usfirst.frc.team4536.utilities.NavXException;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Audrey
 * Command for choosing alliance color
 */
public class AllianceChooser extends CommandBase {
	
	SendableChooser allianceChooser;

    public AllianceChooser() {
    	allianceChooser = new SendableChooser();
    	
    	allianceChooser.addDefault("Red; ", 0);
    	allianceChooser.addObject("Blue: ", 1);
    	
    	SmartDashboard.putData(" Auto Chooser", allianceChooser);
    }
    
    protected void initialize() {
    	switch ((int) allianceChooser.getSelected().hashCode()) {
    		case 1:
    			OI.setFeederStationAngle(Constants.BLUE_FEEDER_STATION_ANGLE);
    		break;
    		default:
    			OI.setFeederStationAngle(Constants.RED_FEEDER_STATION_ANGLE);
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
