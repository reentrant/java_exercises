package catchingAndThrowingExceptions;

import java.util.Scanner;

public class Day16 {
	
	public static int convertStringToInteger(String string) {
		int result = 0;
		try {
			result = Integer.parseInt(string);
		}
		catch(NumberFormatException e) {
			System.out.println("Bad String");
		}
			
		
			
		return result;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        System.out.println(convertStringToInteger(S));
    }
}