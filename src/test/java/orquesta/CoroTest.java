package orquesta;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoroTest {

	@Test
	public void testCoro() {
		System.out.println(new Coro("Avril", Genero.MUJER, TipoCoro.BAJO));
		System.out.println(new Coro("Marisa", Genero.MUJER, TipoCoro.BARITONO));
	}

	@Test
	public void testGetTipo() {
		Coro c = new Coro();
		System.out.println(c);
	}

	@Test
	public void testSetTipo() {
		fail("Not yet implemented"); // TODO
	}

}
