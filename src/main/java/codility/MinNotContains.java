package codility;

import java.util.stream.Collectors;

/**
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000..1,000,000].
 * 
 * Refs:
 * https://www.geeksforgeeks.org/find-all-missing-numbers-from-a-given-sorted-array/
 * https://mkyong.com/java8/java-8-foreach-print-with-index/
 * 
 * 
 */
public class MinNotContains {

    public int solution(int[] arr) {

        java.util.List<Integer> lastPositive = java.util.Arrays.stream(arr).boxed()
                // .filter(i -> i > 0)
                .sorted()
                .collect(Collectors.toList());

        Integer next = Integer.valueOf(0);
        for (int i = 0; i < lastPositive.size() - 1; i++) {
            Integer curr = lastPositive.get(i);
            next = lastPositive.get(i + 1);
            if (next - curr > 1) {
                next = curr;
                break;
            }
        }
        return next + 1;

    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 6, 4, 1, 2 };
        // int[] a = { 1, 3, 2 };
        // int[] a = { -1, -3 };

        System.out.printf("\n%s :: %s smallest positive integer %d\n", MinNotContains.class.getName(), a,
                new MinNotContains().solution(a));

        // System.out.println(new Brackets().sanitize(s));
    }
}