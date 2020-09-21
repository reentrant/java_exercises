package orquesta;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class CantanteTest {

//	@Test
//	public void testCantante() {
//		Cantante c = new Cantante();
//		System.out.println(c);
//
//	}
	
	@Test
	public void testArray() {
		Orquesta[] orquesta = {
				new Cantante("Marisa", Genero.MUJER),
				new Cantante("Avril", Genero.MUJER),
		};
		ArrayList<Cantante> cantantes = new ArrayList<>();
        ArrayList<Instrumento> instrumentos = new ArrayList<>();
        for (Orquesta elemento: orquesta) {
        	System.out.println(elemento);
        }
        System.out.println("== testArray");
	}
	
	@Test
	public void testMostarCantantes() {
		Orquesta[] orquesta = {
				new Coro("Marisa", Genero.MUJER, TipoCoro.BAJO),
				new Solista("Avril", Genero.MUJER, TipoSolista.SOPRANO),
		};
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
        System.out.println("== testMostarCantantes");
	}

	@Test
	public void testMostarInstrs() {
		Persona p = new Persona("Test", Genero.MUJER);
		Orquesta[] orquesta = {
				new Cuerda(p, "Violin"),
				new Viento(p, "flauta"),
				new Cuerda(p, "Guitarra"),
				
		};
		ArrayList<Cantante> cantantes = new ArrayList<>();
        ArrayList<Instrumento> instrumentos = new ArrayList<>();
        for (Orquesta elemento: orquesta) {
        	if (elemento.getClass().equals(Solista.class) || elemento.getClass().equals(Coro.class)) {
        		cantantes.add((Cantante) elemento);
        	} else {
        		instrumentos.add((Instrumento) elemento);
        	}
        	System.out.println(elemento);
        }
        Collections.sort(cantantes);
        Collections.sort(instrumentos);
        for (Instrumento c: instrumentos) {
        	System.out.println(c);
        }
        System.out.println("== testMostarInstrs");
	}
	
}
