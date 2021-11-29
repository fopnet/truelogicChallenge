package geekHunter.example1;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

public class SystemInTest {
	@Test
	public void testSystemInOut() throws FileNotFoundException {

		InputStream in = getClass().getClassLoader().getResourceAsStream("input.txt");
		
		System.setIn(in);
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			System.out.println(scanner.nextLine());			
		}
		scanner.close();

	}
}
