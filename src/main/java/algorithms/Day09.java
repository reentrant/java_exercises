package algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Day09 {
	// Complete the factorial function below.
    static int factorial(int n) {
    	int result;
    	if (n <= 1) {
    		result = 1;
    	}else {
    		result = n * factorial(n - 1);
    	}
		return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = factorial(n);
        System.out.println(result);
        scanner.close();
        
    }
}
