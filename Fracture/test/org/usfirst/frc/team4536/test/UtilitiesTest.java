package org.usfirst.frc.team4536.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.usfirst.frc.team4536.utilities.Utilities;

public class UtilitiesTest {

	@Test
	public void testLimit3Parameters() {
		assertEquals(Utilities.limit(0, 2, 5), 2, 0);
		assertEquals(Utilities.limit(6, 3, 5), 5, 0);
		assertEquals(Utilities.limit(3, 2, 5), 3, 0);
		assertEquals(Utilities.limit(-7, -6, 5), -6, 0);
		assertEquals(Utilities.limit(-5, -6, -7), -7, 0);
		assertEquals(Utilities.limit(-4, -8, 8), -4, 0);
	}
	
	
	
	@Test
	public void testLimit2Parameters() {
		assertEquals(Utilities.limit(0, 2), 0, 0);
		assertEquals(Utilities.limit(3, 1), 1, 0);
		assertEquals(Utilities.limit(4, 4), 4, 0);
		assertEquals(Utilities.limit(-3, -5), 5, 0);
		assertEquals(Utilities.limit(-7, 2), -2, 0);
		assertEquals(Utilities.limit(-8, 9), -8, 0);
	}
	
	@Test
	public void testLimit1Parameters() {
		assertEquals(Utilities.limit(2), 1, 0);
		assertEquals(Utilities.limit(-3), -1, 0);
		assertEquals(Utilities.limit(1), 1, 0);	
	}
	
	@Test
	public void testSpeedCurve() {
		assertEquals(Utilities.speedCurve(1, 2), 1, 0);
		assertEquals(Utilities.speedCurve(-2, 4), -1, 0);
		assertEquals(Utilities.speedCurve(0, -2), 0, 0);
	}
	
	@Test
	public void testDeadZone() {
		assertEquals(Utilities.deadZone(3, 1), 3, 0);
		assertEquals(Utilities.deadZone(0, 2), 0, 0);
		assertEquals(Utilities.deadZone(-5, -4), -5, 0);
		assertEquals(Utilities.deadZone(-5, 6), 0, 0);
	}
	
	@Test
	public void testAngleConverter() {
		assertEquals(Utilities.angleConverter(45), 45, 0);
		assertEquals(Utilities.angleConverter(-990), 90, 0);
		assertEquals(Utilities.angleConverter(990), -90, 0);
		assertEquals(Utilities.angleConverter(0), 0, 0);
		assertEquals(Utilities.angleConverter(279), -81, 0);
		assertEquals(Utilities.angleConverter(-366), -6, 0);
	}
	
	@Test
	public void testAngleDifference() {
		assertEquals(Utilities.angleDifference(-170, -130), 40, 0);
		assertEquals(Utilities.angleDifference(-100, -146), -46, 0);
		assertEquals(Utilities.angleDifference(-53, 0), 53, 0);
		assertEquals(Utilities.angleDifference(1, -137), -138, 0);
		assertEquals(Utilities.angleDifference(71, 146), 75, 0);
	}
	
	@Test 
	public void testShortestAngle() {
		assertEquals(Utilities.shortestAngle(-991, -553), 78, 0);
		assertEquals(Utilities.shortestAngle(0, -366), -6, 0);
		assertEquals(Utilities.shortestAngle(991, 279), 8, 0);
		assertEquals(Utilities.shortestAngle(1, 180), -1, 0);
		assertEquals(Utilities.shortestAngle(0, 0), 0, 0);
		assertEquals(Utilities.shortestAngle(30, 60), 30, 0);
		assertEquals(Utilities.shortestAngle(45, 160), -65, 0);
	}
	@Test 
	public void testAdjustForStiction() {	
		double result = ((-11.0/12.0)*(1.0-0.1))-0.1;
		assertEquals(Utilities.adjustForStiction(-11, 0.1, 12), result, 0);
		result = ((15.0/19.0)*(1.0-0.005))+0.005;
		assertEquals(Utilities.adjustForStiction(15, 0.005, 19), result, 0);
		assertEquals(Utilities.adjustForStiction(0, 0.015, -10), 0, 0);
		result = ((-13.0/-15.0)*(1.0-0.26))-0.26;
		assertEquals(Utilities.adjustForStiction(-13, 0.26, -15), result, 0);
	}
	@Test 
	public void testScale() {
		double result1 = (-0.9*0.6/(0.9+0.5));
		assertEquals(Utilities.scale(-0.9, -0.5, 0.6), result1, 0);
		result1 = (-0.4*0.0/(0.4+0.2));
		assertEquals(Utilities.scale(-0.4, 0.2, 0), result1, 0);
		result1 = (0.7*0.8/(0.7+0.3));
		assertEquals(Utilities.scale(0.7, -0.3, 0.8), result1, 0);
		result1 = (0.0*0.9/(0.0+0.1));
		assertEquals(Utilities.scale(0, 0.1, 0.9), result1, 0);
		result1 = (0.2*0.1/(0.2+0.9));
    	assertEquals(Utilities.scale(0.2, 0.9, 0.1), result1, 0);
	}
}
