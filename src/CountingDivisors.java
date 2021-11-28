
/**
 * Let’s count the number of divisors of n. The easiest approach is to iterate
 * through all the numbers from 1 to n and check whether or not each one is a
 * divisor.
 * 
 * The time complexity of this solution is O(n). There is a simple way to
 * improve the above solution. Based on one divisor, we can find the symmetric
 * divisor. More precisely, if number a is a divisor of n, then n a is also a
 * divisor.
 * 
 * One of these two divisors is less than or equal to √n. (If that were not the
 * case, n would be a product of two numbers greater than √n, which is
 * impossible.)
 * 
 * Thus, iterating through all the numbers from 1 to √n allows us to find all
 * the divisors. If number n is of the form k^2, then the symmetric divisor of k
 * is also k. This divisor should be counted just once
 */
public class CountingDivisors {

    public int solution(int n) {
        return divisors(n);
    }

    int divisors(int n) {
        int i = 1;
        int result = 0;

        while (i * i < n) {

            if (n % i == 0) {
                result += 2;
            }
            i++;
        }
        if (i * i == n) {
            result++;
        }
        return result;

    }

    public static void main(String[] args) {
        // 9-> 3

        int n = 27;
        System.out.printf("CountingDivisors of %d is %d \n", n, new CountingDivisors().solution(n));
    }
}