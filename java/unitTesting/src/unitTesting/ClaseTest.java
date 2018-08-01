package unitTesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClaseTest {

	public ClaseTest() {
		System.out.println("constructor de ClaseTest");
	}
	
	@Test
	public void testClase() {
		//fail("    1.Not yet implemented");
		assertTrue(true);
		System.out.println("    1.Not yet implemented");
	}
	
	@BeforeClass
	public static void antesDeLaClase() {
		System.out.println("**Antes de la clase**");
	}
	
	@AfterClass
	public static void despuesDeLaClase() {
		System.out.println("**Despues de la clase**");
	}

	@After
	public void metodoAfter() {
		System.out.println("  metodoAfter *");
	}
	
	@Test
	public void pruebaRepetida() {
		System.out.println("    2.prueba repetida.");
	}
	
	@Test
	public void testPrueba() {
		assertNotNull(new Clase());
		
		assertEquals(null, new Clase().prueba(1));
		
		System.out.println("    3. test prueba.");
	}

	@Before
	public void metodoBefore() {
		System.out.println("  metodoBefore +");
	}
}
