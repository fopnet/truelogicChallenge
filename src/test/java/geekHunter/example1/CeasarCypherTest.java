package geekHunter.example1;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class CeasarCypherTest {

	@Test
	public void testCeasarCypher() {
		
		List<String> lista = Arrays.asList(
				"GEEK HUNTER", 
				"AWSOME JOBS","TOP DEVELOPERS IN BRAZIL", 
				"I AM GONNA ROCK IN THIS TEST");
		List<String> resposta = new ArrayList<String>();
		
		for( String t : lista)
			resposta.add(CeasarCypher.cipher(t));
		
		asserts(resposta);
		
	}

	public void asserts(List<String> resposta) {
		assertEquals("Cifra não esperada de " + resposta.get(0), "JHHN KXQWHU", resposta.get(0));
		assertEquals("Cifra não esperada de " + resposta.get(1), "DZVRPH MREV", resposta.get(1));
		assertEquals("Cifra não esperada de " + resposta.get(2), "WRS GHYHORSHUV LQ EUDCLO", resposta.get(2));
		assertEquals("Cifra não esperada de " + resposta.get(3), "L DP JRQQD URFN LQ WKLV WHVW", resposta.get(3));
	}
	
	@Test
	public void testSystemInOut()  {

		InputStream in = getClass().getClassLoader().getResourceAsStream("input.txt");
		
		System.setIn(in);
		
		List<String> resposta = new ArrayList<String>();
		try (Scanner scanner = new Scanner(System.in)) {
			
			while(scanner.hasNext()) {
				resposta.add(CeasarCypher.cipher(scanner.nextLine()));			
			}
		} finally {
		
			asserts(resposta);
//			scanner.close();
		}

	}


}
