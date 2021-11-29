package geekHunter.example1;

public class CeasarCypher {

	public static String cipher(String t) {

		String res = "";
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			
//			System.out.println(c);
			if ( c == 90) {
				c = (char)67;
			} else if (!Character.isWhitespace(c)) {
				c += 3;
			}

			res += String.valueOf(c);
		}
		
		return res;
	}
}
