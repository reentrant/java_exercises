package startingJava;

import java.util.Scanner;

public class ExampleConditionals {
	/**
	 * // TODO El objetivo del ejercicio es crear un sistema de calificaciones,
	 * como sigue: El usuario proporcionará un valor entre 0 y 10. 
	 * Si está entre 9 y 10: imprimir una A 
	 * Si está entre 8 y menor a 9: imprimir una B 
	 * Si está entre 7 y menor a 8: imprimir una C
	 * Si está entre 6 y menor a 7: imprimir una D 
	 * Si está entre 0 y menor a 6: imprimir una F 
	 * cualquier otro valor debe imprimir: Valor desconocido
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int grade = scanner.nextInt();
		char result = '0';
		if (grade >= 0 && grade < 11) {
			if (grade > 8) {
				result = 'A';
			} else if (grade > 7 && grade < 9) {
				result = 'B';
			} else if (grade > 6 && grade < 8) {
				result = 'C';
			} else if (grade > 5 && grade < 7) {
				result = 'D';
			} else {
				result = 'F';
			}
			System.out.println("" + Character.toString(result));
		} else
			System.out.println("Valor desconocido");
	}
}
