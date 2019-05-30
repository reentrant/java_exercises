package startingJava;
/**
 * Exercise Loops and Conditionals
 */
 
public class DaysInMonth {

	public static void main(String[] args) {
		int month = 2;
		int days = 0;
		int years[] = {1900, 2000, 2012, 2014, 2016, 2100};
		for (int i=0; i < years.length; i++)
		{
    		if(month == 2 && isLeapYear(years[i])){
    		    days = 29;
	    	}
	    	else{
	    	    days = daysInMonth(month);
	    	}
	    	System.out.println("In " + years[i] + ", the month " + month + " has " + days + " days");
		}
	
	}
    /*
     * Algorithm:
        
        if (year is not divisible by 4) then (it is a common year)
        else if (year is not divisible by 100) then (it is a leap year)
        else if (year is not divisible by 400) then (it is a common year)
        else (it is a leap year)
     */
	public static boolean isLeapYear(int year){
	    boolean leapYear = false;
	    if (year % 4 != 0){
	        leapYear = false;
	    }
	    else if (year % 100 != 0){
	        leapYear = true;
	    }
	    else if (year % 400 != 0){
	        leapYear = false;
	    }
	    else
	        leapYear = true;
	        
	   return leapYear;
	}
	
	public static int daysInMonth(int month){
	    int days;
		if(month == 4 || month == 9 || month == 6 || month == 9 || month == 11){
		    days = 30;
		}else if(month == 2){
		    days = 28;
		}else{
		    days = 31;
		}
	    return days;
	}
}
