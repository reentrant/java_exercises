package startingJava;

import java.util.List;
import java.util.Scanner;

public class Day06CharArrays {
	public static void solution(String string) {
		char[] array = string.toCharArray();
		String evens = "", odds = " ";
		
		for (int i = 0; i < array.length; i++) {
			if (i % 2 == 0) {
				evens += array[i];
			}else {
				odds += array[i];
			}
		}
		System.out.println(evens + odds);
	}
	
	
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		int numberOfCases = input.nextInt();
		input.nextLine();
		for (int i = 0; i < numberOfCases; i++) {
			String string = input.nextLine();
			solution(string);
		}
	}

}
