package startingJava;

import java.util.Random;

public class ExampleRandomNumbers {
	public static void main(String[] args) {
		int samplesNumber = 5;
		System.out.println("--- Using java.util.Random -----------");
		Random objGenerator = new Random();
		for (int iCount = 0; iCount < samplesNumber; iCount++) {
			int randomNumber = objGenerator.nextInt(10);
			System.out.println("Random # : " + randomNumber);
		}

		System.out.println("--- Using java.lang.Math.random() -----------");
		for (int xCount = 0; xCount < samplesNumber; xCount++) {
			System.out.println(Math.random());
		}

	}// main
}// class
