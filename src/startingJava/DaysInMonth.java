package startingJava;
/**
 * Do not change the first two 
 * lines of this program. They
 * are used to declare the Main
 * class and the main method. 
 */
 
public class DaysInMonth {

	public static void main(String[] args) {
		int m = 2;
		int d = 0;
		int years[] = {1900, 2000, 2012, 2014, 2016, 2100};
		for (int i=0; i < years.length; i++)
		{
    		if(m == 2 && isLeapYear(years[i])){
    		    d = 29;
	    	}
	    	else{
	    	    d = daysInMonth(m);
	    	}
	    	System.out.println("In "+ years[i] +", the month "+ m +" has "+ d +" days");
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
	    boolean leap = false;
	    if (year % 4 != 0){
	        leap = false;
	    }
	    else if (year % 100 != 0){
	        leap = true;
	    }
	    else if (year % 400 != 0){
	        leap = false;
	    }
	    else
	        leap = true;
	        
	   return leap;
	}
	
	public static int daysInMonth(int m){
	    int days;
		if(m == 4 || m == 9 || m == 6 || m == 9 || m == 11){
		    days = 30;
		}else if(m == 2){
		    days = 28;
		}else{
		    days = 31;
		}
	    return days;
	}
}
