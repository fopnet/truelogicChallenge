
/**
 * The primality test of n can be performed in an analogous way to counting the
 * divisors. If we find a number between 2 and n − 1 that divides n then n is a
 * composite number. Otherwise, n is a prime number.
 * 
 * ref: https://www.di-mgt.com.au/primes1000.html
 */
public class Primality {

    public boolean solution(int n) {
        int i = 2;

        while (i * i <= n) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        // 17425170 -> true
        // 53 -> true
        // 257 -> true
        // 3889 -> true

        int n = 2858;
        System.out.printf("Primality of %d is %b \n", n, new Primality().solution(n));
    }
}