package algorithms;

import static org.junit.Assert.*;
import org.junit.Test;

public class Day26Test {

	@Test
	public void testCase4() {
		Date actual = new Date(new int [] {1, 1, 2010});
		Date expectedDelivery = new Date(new int [] {31, 12, 2009});
//		actual.displayDate("actual date: ");
//		expectedDelivery.displayDate("Expected delivery: ");
		Day26DatesDifference classTest = new Day26DatesDifference(actual, expectedDelivery);
		int fine = classTest.substractDates();
		System.out.println(fine);
		assertTrue("testNextDayIsNextMonth", fine == 10000);
	}

	
	@Test
	public void testDeliveredWithinOneMonthNextYear() {
		Date actual = new Date(new int [] {31, 3, 2016});
		Date expectedDelivery = new Date(new int [] {31, 12, 2015});
//		actual.displayDate("actual date: ");
//		expectedDelivery.displayDate("Expected delivery: ");
		Day26DatesDifference classTest = new Day26DatesDifference(actual, expectedDelivery);
		int fine = classTest.substractDates();
//		System.out.println(fine);
		assertTrue("testNextDayIsNextMonth", fine == 1500);
	}
	
	
	@Test
	public void testNextDayIsNextYear() {
		Date actual = new Date(new int [] {1, 1, 2016});
		Date expectedDelivery = new Date(new int [] {31, 12, 2015});
//		actual.displayDate("actual date: ");
//		expectedDelivery.displayDate("Expected delivery: ");
		Day26DatesDifference classTest = new Day26DatesDifference(actual, expectedDelivery);
		int fine = classTest.substractDates();
		assertTrue("testNextDayIsNextMonth", fine == 15);
	}
	
	
	@Test
	public void testNextDayIsNextMonthCase2() {
		Date actual = new Date(new int [] {28, 2, 2015});
		Date expectedDelivery = new Date(new int [] {31, 1, 2015});
//		actual.displayDate("actual date: ");
//		expectedDelivery.displayDate("Expected delivery: ");
		Day26DatesDifference classTest = new Day26DatesDifference(actual, expectedDelivery);
		int fine = classTest.substractDates();
		assertTrue("testNextDayIsNextMonth", fine == 500);
	}
	
	@Test
	public void testNextDayIsNextMonth() {
		Date actual = new Date(new int [] {1, 2, 2015});
		Date expectedDelivery = new Date(new int [] {31, 1, 2015});
//		actual.displayDate("actual date: ");
//		expectedDelivery.displayDate("Expected delivery: ");
		Day26DatesDifference classTest = new Day26DatesDifference(actual, expectedDelivery);
		int fine = classTest.substractDates();
		assertTrue("testNextDayIsNextMonth", fine == 15);
	}
	
	@Test
	public void testGetNextDay() {
		Date d1 = new Date(new int [] {29, 11, 2019});
//		d1.displayDate("Current: ");
		Day26DatesDifference classTest = new Day26DatesDifference();
		Date d2 = classTest.getNextDay(d1);
//		d2.displayDate("Next day: ");
		assertEquals("Consequtive", d1, d2);
	}

	@Test
	public void testMonthBefore() {
		Date d1 = new Date(new int [] {12, 12, 2014});
		Date d2 = new Date(new int [] {1, 2, 2015});
//		d1.displayDate("actual date: ");
//		d2.displayDate("Expected delivery: ");
		Day26DatesDifference classTest = new Day26DatesDifference();
		assertEquals("delivering before", true, classTest.isDateOnOrBefore(d1, d2));
	}
	
	@Test
	public void testLastDayInMonthIsBefore() {
		Date d1 = new Date(new int [] {31, 1, 2015});
		Date d2 = new Date(new int [] {1, 2, 2015});
//		d1.displayDate("actual date: ");
//		d2.displayDate("Expected delivery: ");
		Day26DatesDifference classTest = new Day26DatesDifference();
		assertEquals("delivering before", true, classTest.isDateOnOrBefore(d1, d2));
	}
	
	
	@Test
	public void testDateBefore() {
		Date d1 = new Date(new int [] {5, 6, 2015});
		Date d2 = new Date(new int [] {6, 6, 2015});
//		d1.displayDate("actual date: ");
//		d2.displayDate("Expected delivery: ");
		Day26DatesDifference classTest = new Day26DatesDifference();
		assertEquals("delivering before", true, classTest.isDateOnOrBefore(d1, d2));
	}
	
	@Test
    public void testDaysInMonth() {
		Day26DatesDifference classTest = new Day26DatesDifference();
		int days = classTest.getDaysInMonth(1, 2019);
		int expected = 31;
		assertTrue("getDaysInMonth", expected == days);
	}
	
	@Test
    public void testDaysInMonthLeapYear() {
		Day26DatesDifference classTest = new Day26DatesDifference();
		int[] leapYears = {1600, 2000, 2020, 2400};
		for (int year: leapYears) {
			int days = classTest.getDaysInMonth(2, year);
			int expected = 29;
			assertTrue("getDaysInMonth", expected == days);	
		}
	}
	
	@Test
    public void testDaysInMonthNotLeapYear() {
		Day26DatesDifference classTest = new Day26DatesDifference();
		int [] commonYears = {2019, 1700, 1800, 1900, 2100, 2200, 2300};
		for (int year: commonYears) {
			int days = classTest.getDaysInMonth(2, year);
			int expected = 28;
			assertTrue("getDaysInMonth", expected == days);
		}
		
	}
	
}

