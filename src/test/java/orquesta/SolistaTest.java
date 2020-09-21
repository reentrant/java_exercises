package orquesta;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolistaTest {

	@Test
	public void test() {
		Solista s = new Solista();
		System.out.println(s);
		s.sonar();
		s.noSonar();
	}
}
