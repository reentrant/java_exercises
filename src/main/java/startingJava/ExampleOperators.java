package startingJava;

import java.util.Scanner;

public class ExampleOperators {

	public ExampleOperators() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Proporciona el numero 1: ");
		int num1 = s.nextInt();
		System.out.println("Proporciona el numero 2: ");
		int num2 = s.nextInt();
		int mayor = (num1 > num2) ? num1 : num2;
		System.out.println("El numero mayor es: " + mayor);
	}

}
