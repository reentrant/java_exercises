package startingJava;

import java.util.Scanner;

public class Day10 {
	private static final Scanner input = new Scanner(System.in);
	
	public static int findTheLongestChainOfOnes(String binaryString) {
	int counter = 0, max = 0;
	boolean one = false;
	char [] binChars = binaryString.toCharArray();
	for (int i = 0; i < binChars.length; i++) {
		if (one == false && binChars[i] == '1') {
			one = true;
			counter = 1;
		} else if (binChars[i] == '1' && one == true) {
			counter += 1;
		} else if (binChars[i] == '0' && one == true) {
			if (counter > max) {
				max = counter;
			}
			counter = 0;
			one = false;
		} else {// was zero and is zero
			
		}
	}
	if (one == true) {
		if (counter > max) {
			max = counter;
		}
	}
	
	return max;
	}

    public static void main(String[] args) {
        int decimalNumber = input.nextInt();
        input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String binNumber = Integer.toBinaryString(decimalNumber);
        System.out.println(findTheLongestChainOfOnes(binNumber));
        input.close();
    }
}
