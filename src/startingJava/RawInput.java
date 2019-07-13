package startingJava;

import java.util.Scanner;

public class RawInput {

	public RawInput() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two numbers");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		System.out.println("The numbers were: " + number1 + " and " + number2);
		input.close();
	}

}
