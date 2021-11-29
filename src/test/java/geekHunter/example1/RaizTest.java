package geekHunter.example1;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class RaizTest {
	

	@Test
	public void testRaiz() {
		
		for (int i = 10; i < 21; i++)
			System.out.println(i + " -> " + Raiz.raiz(i, 2, 5, 0.0001d));

	}

	
}
