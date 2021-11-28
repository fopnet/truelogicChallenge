import java.math.BigInteger;

public class Fibonacci {
    /**
     * @formatter:off
     * position 1, 2, 3, 4, 5, 6, 7, 08, 09, 10
     * Result   1, 1, 2, 3, 5, 8, 13, 21, 34, 55
     * fib(1)  -> 0
     * fib(2)  -> 1
     * fib(3)  -> 2
     * fib(4)  -> 3
     * fib(5)  -> 5
     * fib(8)  -> 21
     * fib(20) -> 6765
     * fib(35) -> 9227465 
     * @formatter:on
     * 
     * 
     * @param n
     * @return
     */
    BigInteger fibo(int n) {
        if (n < 0) {
            throw new RuntimeException("Parameter must be higher than 0");
        }

        if (n == 0) {
            return BigInteger.ZERO;
        } else if (n <= 2) {
            return BigInteger.ONE;
        } else {
            return fibo(n - 1).add(fibo(n - 2));
        }

    }

    public static void main(String[] args) {
        int n = 5;
        System.out.printf("Fib of %d is %d \n", n, new Fibonacci().fibo(n));
    }
}
