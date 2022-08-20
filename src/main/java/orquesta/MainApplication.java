package orquesta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class MainApplication {
	public static Orquesta[] orquesta;

	
	public MainApplication() {
	}

	public static void main(String[] args) {
		crearOrquesta();
		MainApplication app = new MainApplication();
		Menu menu = new Menu();
		int opcion;
		do {
			menu.mostrar();
			opcion = menu.leerMenuPrincipal();
			switch(opcion) {
			case 0:
				break;
			case 1:
				app.mostrarOrquesta();
				break;
			case 2:
				app.mostarOrquestaSonando();
				break;
			case 3:
				app.hacerSonar();
				break;
			case 4:
				app.dejarDeSonar();
				break;
			case 5:
				app.hacerCantar();
				break;
			case 6:
				app.dejarDeCantar();
				
			default:
				break;
			}
			
		} while (opcion != 0);

	}

	private static void crearOrquesta() {
		Menu menu = new Menu();
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantos integrantes tiene la orquesta?");
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

	void mostrarOrquesta() {
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
	
	void mostarOrquestaSonando() {
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
			System.out.println("La orquesta no esta sonando en este momento");
		}
		System.out.println();
	}

	void hacerSonar() {
		ArrayList<Cantante> cantantes = new ArrayList<>();
		ArrayList<Instrumento> instrumentos = new ArrayList<>();
		ArrayList<Instrumento> instrumentosNoSonando = new ArrayList<>();

        for (Orquesta elemento: orquesta) {
        	if (elemento.getClass().equals(Solista.class) || elemento.getClass().equals(Coro.class)) {
        		cantantes.add((Cantante) elemento);
        	} else {
        		instrumentos.add((Instrumento) elemento);
        		if (((Instrumento) elemento).getSonando() == false) {
        			instrumentosNoSonando.add((Instrumento) elemento);
        		}
        	}
        }
        
        if (instrumentos.isEmpty()) {
        	System.out.println("No hay instrumentos en la orquesta");
        } else if (instrumentosNoSonando.isEmpty()) {
        	System.out.println("Todos los instrumentos ya estan sonando");
        } else if (instrumentosNoSonando.size() == 1) {
        	instrumentosNoSonando.get(0).sonar();
        } else if (instrumentosNoSonando.size() == 2) {
        	for (Instrumento i : instrumentosNoSonando) {
        		i.sonar();
        	}
        } else {
        	// Ordena sonar a dos instrumentos.
        	for (int i=0; i < 2; i++) {
        		int index = (int) (instrumentosNoSonando.size() * Math.random());
        		instrumentosNoSonando.get(index).sonar();
        	}
        }
        System.out.println();
	}

	void dejarDeSonar() {
		ArrayList<Cantante> cantantes = new ArrayList<>();
		ArrayList<Instrumento> instrumentos = new ArrayList<>();
		ArrayList<Instrumento> instrumentosSonando = new ArrayList<>();

        for (Orquesta elemento: orquesta) {
        	if (elemento.getClass().equals(Solista.class) || elemento.getClass().equals(Coro.class)) {
        		cantantes.add((Cantante) elemento);
        	} else {
        		instrumentos.add((Instrumento) elemento);
        		if (((Instrumento) elemento).getSonando()) {
        			instrumentosSonando.add((Instrumento) elemento);
        		}
        	}
        }
        
        if (instrumentos.isEmpty()) {
        	System.out.println("No hay instrumentos en la orquesta");
        } else if (instrumentosSonando.isEmpty()) {
        	System.out.println("Ningun instrumento esta sonando");
        } else {
        	int index = (int) (instrumentosSonando.size() * Math.random());
        	instrumentosSonando.get(index).noSonar();
        }
        System.out.println();
	}

	void hacerCantar() {
		ArrayList<Cantante> cantantes = new ArrayList<>();
		ArrayList<Cantante> cantantesNoCantando = new ArrayList<>();
		ArrayList<Instrumento> instrumentos = new ArrayList<>();

        for (Orquesta elemento: orquesta) {
        	if (elemento.getClass().equals(Solista.class) || elemento.getClass().equals(Coro.class)) {
        		cantantes.add((Cantante) elemento);
        		if (((Cantante) elemento).getCantando() == false) {
        			cantantesNoCantando.add((Cantante) elemento);
        		}
        	} else {
        		instrumentos.add((Instrumento) elemento);
        	}
        }
        
        if (cantantes.isEmpty()) {
        	System.out.println("No hay cantantes en la orquesta");
        } else if (cantantesNoCantando.isEmpty()) {
        	System.out.println("Todos los cantantes ya estan cantando");
        } else {

    		int index = (int) (cantantesNoCantando.size() * Math.random());
    		cantantesNoCantando.get(index).sonar();
        	
        }
        System.out.println();
	}
	
	void dejarDeCantar() {
		ArrayList<Cantante> cantantes = new ArrayList<>();
		ArrayList<Cantante> cantantesCantando = new ArrayList<>();
		ArrayList<Instrumento> instrumentos = new ArrayList<>();
		
		for (Orquesta elemento: orquesta) {
        	if (elemento.getClass().equals(Solista.class) || elemento.getClass().equals(Coro.class)) {
        		cantantes.add((Cantante) elemento);
        		if (((Cantante) elemento).getCantando()) {
        			cantantesCantando.add((Cantante) elemento);
        		}
        	} else {
        		instrumentos.add((Instrumento) elemento);
        	}
        }
        
        if (cantantes.isEmpty()) {
        	System.out.println("No hay cantantes en la orquesta");
        } else if (cantantesCantando.isEmpty()) {
        	System.out.println("Ningun cantante esta cantando");
        } else {
        	int index = (int) (cantantesCantando.size() * Math.random());
        	cantantesCantando.get(index).noSonar();
        }
        System.out.println();
		
	}
}
