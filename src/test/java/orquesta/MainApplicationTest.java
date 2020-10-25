package orquesta;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class MainApplicationTest {

	@Test
	public void testMostrarOrquesta() {
		MainApplication aut = new MainApplication();
		ArrayList<Cantante> cantantes = new ArrayList<>();
        ArrayList<Instrumento> instrumentos = new ArrayList<>();
		Persona p = new Persona("Test", Genero.MUJER);
		Orquesta [] orquesta = {
				new Coro("Mary", Genero.MUJER, TipoCoro.BAJO),
				new Solista("April", Genero.MUJER, TipoSolista.SOPRANO),
				new Cuerda(p, "Violin"),
				new Viento(p, "flauta"),
				new Cuerda(p, "Guitarra")};
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

	@Test
	public void testMostarOrquestaSonando() {
		ArrayList<Cantante> cantantes = new ArrayList<>();
        ArrayList<Instrumento> instrumentos = new ArrayList<>();
		Persona p = new Persona("Test", Genero.MUJER);
		Orquesta [] orquesta = {
				new Coro("Mary", Genero.MUJER, TipoCoro.BAJO),
				new Solista("April", Genero.MUJER, TipoSolista.SOPRANO),
				new Cuerda(p, "Violin"),
				new Viento(p, "flauta"),
				new Cuerda(p, "Guitarra")};
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

	@Test
	public void testHacerSonar() {
		ArrayList<Cantante> cantantes = new ArrayList<>();
        ArrayList<Instrumento> instrumentos = new ArrayList<>();
        ArrayList<Instrumento> instrumentosNoSonando = new ArrayList<>();
		Persona p = new Persona("Test", Genero.MUJER);
		Orquesta [] orquesta = {
				new Coro("Mary", Genero.MUJER, TipoCoro.BAJO),
				new Solista("April", Genero.MUJER, TipoSolista.SOPRANO),
				new Cuerda(p, "Violin"),
				new Viento(p, "flauta"),
				new Cuerda(p, "Guitarra")
				};
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

	@Test
	public void testDejarDeSonar() {
		ArrayList<Cantante> cantantes = new ArrayList<>();
        ArrayList<Instrumento> instrumentos = new ArrayList<>();
		Persona p = new Persona("Test", Genero.MUJER);
		Orquesta [] orquesta = {
				new Coro("Mary", Genero.MUJER, TipoCoro.BAJO),
				new Solista("April", Genero.MUJER, TipoSolista.SOPRANO),
				new Cuerda(p, "Violin"),
				new Viento(p, "flauta"),
				new Cuerda(p, "Guitarra")};
	}

	@Test
	public void testHacerCantar() {

		ArrayList<Cantante> cantantes = new ArrayList<>();
		ArrayList<Cantante> cantantesNoCantando = new ArrayList<>();
		ArrayList<Instrumento> instrumentos = new ArrayList<>();

		Persona p = new Persona("Test", Genero.MUJER);
		Orquesta [] orquesta = {
				new Coro("Mary", Genero.MUJER, TipoCoro.BAJO),
				new Solista("April", Genero.MUJER, TipoSolista.SOPRANO),
				new Cuerda(p, "Violin"),
				new Viento(p, "flauta"),
				new Cuerda(p, "Guitarra")};
		
        for (Orquesta elemento: orquesta) {
        	if (elemento.getClass().equals(Solista.class) || elemento.getClass().equals(Coro.class)) {
        		cantantes.add((Cantante) elemento);
        		//((Cantante) elemento).setCantando(true);
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

	@Test
	public void testDejarDeCantar() {
		
		Persona p = new Persona("Test", Genero.MUJER);
		Orquesta [] orquesta = {
				new Coro("Mary", Genero.MUJER, TipoCoro.BAJO),
				new Solista("April", Genero.MUJER, TipoSolista.SOPRANO),
				new Cuerda(p, "Violin"),
				new Viento(p, "flauta"),
				new Cuerda(p, "Guitarra")};
		ArrayList<Cantante> cantantes = new ArrayList<>();
		ArrayList<Cantante> cantantesCantando = new ArrayList<>();
		ArrayList<Instrumento> instrumentos = new ArrayList<>();
		
		for (Orquesta elemento: orquesta) {
        	if (elemento.getClass().equals(Solista.class) || elemento.getClass().equals(Coro.class)) {
        		((Cantante) elemento).sonar();
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
