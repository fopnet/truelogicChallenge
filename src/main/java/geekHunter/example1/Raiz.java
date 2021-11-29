package geekHunter.example1;

import java.text.DecimalFormat;

/**
 * Hello world!
 *
 */
public class Raiz {
	
	
	public static String raiz(double x, double s, double e, double precision) {
		double dif = (e - s);
		double m = s + (double) (dif / 2);

		if (dif < precision) {
			return new DecimalFormat("0.000").format(m);
			// return new BigDecimal(m).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
		}

		if (m * m > x) {
			return raiz(x, s, m, precision);
		} else {
			return raiz(x, m, e, precision);
		}
	}

}
