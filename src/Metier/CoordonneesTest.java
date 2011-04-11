package Metier;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoordonneesTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculDistance() {
		assert (Coordonnees.calculDistance(0, 0, 3, 4)==5);
		//fail("Not yet implemented");
	}

}
