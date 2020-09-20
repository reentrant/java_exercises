package orquesta;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolistaTest {

	@Test
	public void test() {
		Solista s = new Solista("Marwan", Genero.HOMBRE, TipoSolista.SOPRANO);
		System.out.println(s);
		System.out.println(new Solista("Guty", Genero.HOMBRE, TipoSolista.TENOR));
		
	}

}
