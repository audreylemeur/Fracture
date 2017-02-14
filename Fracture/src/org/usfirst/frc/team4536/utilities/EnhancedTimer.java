package org.usfirst.frc.team4536.utilities;

import edu.wpi.first.wpilibj.Timer;

public class EnhancedTimer {

	/*------------------------------------------------Objects---------------------------------------------*/
	
		private Timer timer;
	
	/*-----------------------------------------------Cycle Time-------------------------------------------*/
	
		private double prevTime = 0.0;
		public static double cycleTime = 0.0;
		
	/*------------------------------------------------methods---------------------------------------------*/
	
		/**
		 * Constructor
		 */
		public EnhancedTimer(){
			
			timer = new Timer();
			
		}
		
		/**
		 *@author Audrey
		 * Starts the timer.
		 */
		public final void startTimer() {
			
			timer.start();
			prevTime = 0.0;
		}
		
		/**
		 * @author Audrey
		 * Resets the timer by making the start time the current time so all time values are then compared to that new more recent time.
		 */
		public final void resetTimer() {
			
			timer.reset();
			prevTime = 0.0;
		}
		
		/**
		 * @author Audrey
		 * Stops the timer.
		 */
		public final void stopTimer() {
			
			timer.stop();
		}
		
		/**
		 * @author Noah
		 * @return Gets the current time in seconds
		 */
		public double getTime() {
			return timer.get();
		}
		
		/**
		 * @author Audrey
		 * Updates the cycle time calculation of our code. This should only be called once per cycle or it will be incorrect.
		 */
		public final void updateCycleTime() {
			
			double currentTime = timer.get();
			cycleTime = currentTime - prevTime;
			prevTime = currentTime;
		}
		
}
