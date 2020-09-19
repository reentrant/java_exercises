package orquesta;

import java.util.Scanner;

public class Main {
	public static Orquesta[] orquesta;

	public static void main(String[] args) {
		crearOrquesta();
		Menu menu = new Menu();
		int opcion;
		do {
			menu.mostrar();
			opcion = menu.leer();
			switch(opcion) {
			case 0:
				break;
			case 1:
				mostrarOrquesta();
				break;
			case 2:
				mostarOrquestaSonando();
				break;
			case 3:
				hacerSonar();
				break;
			case 4:
				dejarDeSonar();
				break;
			case 5:
				hacerCantar();
				break;
			case 6:
				dejarDeCantar();
				
			default:
				break;
			}
			
		} while (opcion != 0);

	}

	private static void crearOrquesta() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿Cuantos integrantes tiene la orquesta?");
		int numeroDeIntegrantes = scanner.nextInt();
		orquesta = new Orquesta[numeroDeIntegrantes];
		scanner.close();
	}

	private static void mostrarOrquesta() {
		// TODO Auto-generated method stub
		
	}
	
	private static void mostarOrquestaSonando() {
		// TODO Auto-generated method stub
		
	}

	private static void hacerSonar() {
		// TODO Auto-generated method stub
		
	}

	private static void dejarDeSonar() {
		// TODO Auto-generated method stub
		
	}

	private static void hacerCantar() {
		// TODO Auto-generated method stub
		
	}
	
	private static void dejarDeCantar() {
		// TODO Auto-generated method stub
		
	}
}
