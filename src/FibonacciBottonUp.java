import java.math.BigInteger;

public class FibonacciBottonUp {

    /**
     * Melhor solução
     * @formatter:off
     * position 1, 2, 3, 4, 5, 6, 7, 08, 09, 10
     * Result   0, 1, 2, 3, 5, 8, 13, 21, 34, 55
     * fib(1)  -> 0
     * fib(2)  -> 1
     * fib(3)  -> 2
     * fib(4)  -> 3
     * fib(5)  -> 5
     * fib(8)  -> 21
     * fib(20) -> 6765
     * fib(35) -> 9227465 
     * fib(100) -> 354224848179261915075
     * @formatter:on
     * 
     * 
     * @param n
     * @return
     */
    BigInteger fibo(int n) {
        BigInteger[] memo = new BigInteger[n + 1];

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
        if (n < 1) {
            throw new RuntimeException("Parameter must be higher than 0");
        }

        if (n <= 2) {
            return BigInteger.valueOf(1);
        } else {
            memo[0] = BigInteger.valueOf(1);
            memo[1] = BigInteger.valueOf(1);
            for (int i = 2; i < memo.length; i++) {
                memo[i] = memo[i - 1].add(memo[i - 2]);
            }
        }

        return memo[n - 1];
    }

    public static void main(String[] args) {
        /**
         * fib(5) -> 5, fib(20) -> 6765, fib(35) -> 9227465
         */
        int n = 10000;
        System.out.printf("Fib of %d is %d \n", n, new FibonacciBottonUp().fibo(n));
    }
}
