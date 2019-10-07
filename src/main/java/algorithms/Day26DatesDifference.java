package algorithms;

import java.util.Scanner;

class Date{
	int day = 0, month = 0, year = 1900;
	Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	Date(int [] numbers){
		if (numbers.length == 3) {
			this.day = numbers[0];
			this.month = numbers[1];
			this.year = numbers[2];
		}
	}
	
	Date(Date date){
		this.day = date.day;
		this.month = date.month;
		this.year = date.year;
	}
	
	void displayDate(String messageID) {
		String separator = "/";
		System.out.println(messageID + this.day + separator + this.month + separator + this.year);
	}
}

public class Day26DatesDifference {
	int[] days_in_month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	Date actualDate;
	Date expectedDelivery;
	
	Day26DatesDifference(){}
		
	Day26DatesDifference(Date actual, Date expected){
		this.actualDate = actual;
		this.expectedDelivery = expected;
	}
	
	void init(int[] array){
		this.actualDate = new Date (array[0], array[1], array[2]);
		this.expectedDelivery = new Date(array[3], array[4], array[5]);
	}
	
	int substractDates(){
		//	If the book is returned on or before the expected return date, no fine will be charged
		int fine = 0;
		int nMonthsLate;
		int nDaysLate;
		if (isDateOnOrBefore(actualDate, expectedDelivery)){
			fine = 0;
		}else {
			// If the book is returned after the calendar year in which it was expected,
			// there is a fixed fine of 10000 h.
			if (actualDate.year > expectedDelivery.year) {
				fine = 10000;
			} else {
				// If the book is returned after the expected return month but still within the same
				// calendar year as the expected return date, the 500 x nMonthsLate.
				if (actualDate.year == expectedDelivery.year) {
					if ((actualDate.month - expectedDelivery.month) > 1) {
						nMonthsLate = actualDate.month - expectedDelivery.month;
						fine = 500 * nMonthsLate;
					} else if (actualDate.month == expectedDelivery.month) {
						// If the book is returned after the expected return day but still within
						// the same calendar month and year as the expected return date, fine = 15n
						nDaysLate = actualDate.day - expectedDelivery.day;
						fine = 15 * nDaysLate;
					}
					else {// calculate days and months late
						Date test = calculateDateDifference();
						if (test.month != 0) {
							fine = test.month * 500;
						}
						else {
							fine = test.day * 15;
						}
					}
				} else {
					// calculate years, days and months late
					Date test = calculateDateDifference();
					if (test.year != 0) {
						fine = 10000;
					} else if (test.month != 0) {
						fine = test.month * 500;
					}
					else {
						fine = test.day * 15;
					}
				}
			}
		}
		return fine;
	}
	
	Date calculateDateDifference() {
		Date testDate = new Date(expectedDelivery);
		Date diff = new Date(0, 0, 0);
		
		while(isDateOnOrBefore(testDate, actualDate)) {
			testDate = getNextDay(testDate);
			diff.day++;
			if(testDate.day == expectedDelivery.day) {
				diff.month++;
				if (diff.month % 12 == 0) {
					diff.year++;
				}
			} else if (isLastDayOfMonth(expectedDelivery) && isLastDayOfMonth(testDate)) {
				diff.month++;
				if (diff.month % 12 == 0) {
					diff.year++;
				}
			}
			if (testDate.day == actualDate.day && testDate.month == actualDate.month &&
					testDate.year == actualDate.year) {
				return diff;
			}
		}
		return diff;
	}
	
	boolean isLastDayOfMonth(Date testDate) {
		boolean result;
		if (getDaysInMonth(testDate.month, testDate.year) == testDate.day)
			result = true;
		else
			result = false;
		return result;
	}
	
	Date getNextDay(Date testDate) {
		if (++testDate.day > getDaysInMonth(testDate.month, testDate.year)){
			testDate.day = 1;
			testDate.month++;
			if (testDate.month == 13) {
				testDate.month = 1;
				testDate.year++; 
			}
		} 
		return testDate;
	}
	
	boolean isDateOnOrBefore(Date firstDate, Date secondDate) {
		if (firstDate.day <= secondDate.day && firstDate.month <= secondDate.month && 
				firstDate.year <= secondDate.year) {
			return true;
		} else if (firstDate.month < secondDate.month && firstDate.year <= secondDate.year) {
			return true;
		} else if (firstDate.year < secondDate.year) {
			return true;
		}
		return false;
	}
	
	int getDaysInMonth(int month, int year) {
		if (month == 2 && isLapYear(year)) {
			return 29;
		}
		else
			return this.days_in_month[month - 1];
	}
	
	boolean isLapYear(int year) {
		/**
		 * From wikipedia:
		    if (year is not divisible by 4) then (it is a common year)
		    else if (year is not divisible by 100) then (it is a leap year)
		    else if (year is not divisible by 400) then (it is a common year)
		    else (it is a leap year)
		 */
		boolean result = false;
		if (year % 4 != 0) {
			result = false;
		}else if(year % 100 != 0) {
			result = true;
		}else if(year % 400 != 0) {
			result = false;
		}else {
			result = true;
		}
		
		return result;
	}
	
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] inputArray = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < inputArray.length; i++){
            inputArray[i] = input.nextInt();
        }
        Day26DatesDifference testClass = new Day26DatesDifference();
        testClass.init(inputArray);
        System.out.println(testClass.substractDates());
    }
}
