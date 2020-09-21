package orquesta;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuerdaTest {


	@Test
	public void testCuerda() {
		Cuerda c1 = new Cuerda();
		System.out.println(c1);
		c1.noSonar();
		Cuerda c2 = new Cuerda();
		System.out.println(c2);
		c2.sonar();
		c2.noSonar();
	}

}
