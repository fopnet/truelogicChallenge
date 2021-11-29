package geekHunter.example1;

public class Mdc {
	public static Integer mdc(Integer dividendo, Integer divisor) {
		if (divisor == 0) {
			return dividendo;
		}

		if (dividendo % divisor == 0) {
			return divisor;
		} else {
			return mdc(divisor, dividendo % divisor);
		}
	}
}
