package startingOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface AdvancedArithmetic{
	   int divisorSum(int n);
	}

class Calculator implements AdvancedArithmetic {
    public int divisorSum(int n) {
    	int total = 0;
    	for (int i = 1; i < n + 1; i++) {
    		if (n % i == 0) {
    			total += i;
    		}
    	}
        return total;
    }
}

public class Day19Interface {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        
      	AdvancedArithmetic myCalculator = new Calculator(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}