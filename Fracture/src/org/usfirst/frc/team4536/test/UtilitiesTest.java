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
	public void testAccelLimit() {
		assertEquals(Utilities.accelLimit(3, 1, 0), 3, 0);
	}
}
