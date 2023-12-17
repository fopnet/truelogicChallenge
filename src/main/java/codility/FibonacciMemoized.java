package codility;

import java.math.BigInteger;

public class FibonacciMemoized {

    /**
     * @formatter:off
     * position 0, 1, 2, 3, 4, 5, 6, 7, 08, 09, 10
     * Result   0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
     * fib(1)  -> 1
     * fib(2)  -> 1
     * fib(3)  -> 2
     * fib(4)  -> 3
     * fib(5)  -> 5
     * fib(20) -> 6765
     * fib(35) -> 9227465 
     * @formatter:on
     * 
     * 
     * @param n
     * @return
     */
    BigInteger fibo(int n) {
        BigInteger[] memo = new BigInteger[n];

        return fibo(n, memo);
    }

    /**
     * Using a Botton-up approach
     * 
     * @param n
     * @param memo
     * @return
     */
    private BigInteger fibo(int n, BigInteger[] memo) {
        if (n < 0) {
            throw new RuntimeException("Parameter must be higher than 0");
        }

        if (n == 0) {
            return BigInteger.ZERO;
        } else if (n <= 2) {
            return BigInteger.ONE;
        } else if (memo[n - 1] != null) {
            return memo[n - 1];
        } else {
            memo[0] = BigInteger.ONE;
            memo[1] = BigInteger.ONE;
            memo[n - 1] = fibo(n - 1, memo).add(fibo(n - 2, memo));
        }

        return memo[n - 1];
    }

    public static void main(String[] args) {
        /**
         * fib(5) -> 5, fib(20) -> 6765, fib(35) -> 9227465
         */
        int n = 5;
        System.out.printf("Fib of %d is %d \n", n, new FibonacciMemoized().fibo(n));
    }
}
