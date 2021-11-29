package geekHunter.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class MdcTest {

	@Test
	public void test() {
		String linha = "16 0";
		Pattern p = Pattern.compile("\\d+");

		Matcher matcher = p.matcher(linha.toString());
		List<Integer> numbers = new ArrayList<Integer>();
		while (matcher.find()) {
			numbers.add(Integer.valueOf(matcher.group()));
		}
		System.out.println(Mdc.mdc(numbers.get(0), numbers.get(1)));

	}
}
