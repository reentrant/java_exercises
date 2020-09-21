package orquesta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class MainApplication {
	public static Orquesta[] orquesta;

	public static void main(String[] args) {
		
		crearOrquesta();
		Menu menu = new Menu();
		int opcion;
		do {
			menu.mostrar();
			opcion = menu.leerMenuPrincipal();
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
		Menu menu = new Menu();
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cuantos integrantes tiene la orquesta?");
		int numeroDeIntegrantes = sc.nextInt();
		orquesta = new Orquesta[numeroDeIntegrantes];
		for (int i=0; i < numeroDeIntegrantes; i++) {
			if (menu.escoger("Escoja Instrumento -> 1 o Cantante -> 2 ?") == 1) {
				if (menu.escoger("Escoja Viento -> 1 o Cuerda -> 2 ?") == 1) {
					orquesta[i] = new Viento();
				} else {
					orquesta[i] = new Cuerda();
				}
			} else {
				if (menu.escoger("Escoja Cantante: Solista -> 1 o Coro -> 2 ?") == 1) {
					orquesta[i] = new Solista();
				} else {
					orquesta[i] = new Coro();
				}
			}
			System.out.println("Nuevo elemento: " + orquesta[i]);
		}
	}

	private static void mostrarOrquesta() {
		ArrayList<Cantante> cantantes = new ArrayList<>();
        ArrayList<Instrumento> instrumentos = new ArrayList<>();
        for (Orquesta elemento: orquesta) {
        	if (elemento.getClass().equals(Solista.class) || elemento.getClass().equals(Coro.class)) {
        		cantantes.add((Cantante) elemento);
        	} else {
        		instrumentos.add((Instrumento) elemento);
        	}
        }
        Collections.sort(cantantes);
        Collections.sort(instrumentos);
        for (Cantante c: cantantes) {
        	System.out.println(c);
        }
        for(Instrumento i: instrumentos) {
        	System.out.println(i);
        }
        System.out.println();
	}
	
	private static void mostarOrquestaSonando() {
		boolean sonando = false;
		for (Orquesta elemento: orquesta) {
			if (elemento.getClass().equals(Solista.class) || elemento.getClass().equals(Coro.class)) {
        		if (((Cantante) elemento).getCantando()) {
        			System.out.println(elemento);
        			sonando = true;
        		}

        	} else {
        		if (((Instrumento) elemento).getSonando()) {
        			System.out.println(elemento);
        			sonando = true;
        		}
        	}
        }
		if (!sonando) {
			System.out.println("La orquesta no está sonando en este momento");
		}
		System.out.println();
	}

	private static void hacerSonar() {
		
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
