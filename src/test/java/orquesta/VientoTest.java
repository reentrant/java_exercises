package orquesta;

import static org.junit.Assert.*;

import org.junit.Test;

public class VientoTest {

	@Test
	public void test() {
		Viento v1 = new Viento();
		System.out.println(v1);
		
		Viento v2 = new Viento();
		System.out.println(v2);
		v2.sonar();
		v2.noSonar();
	}

}
