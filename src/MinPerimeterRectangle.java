/**
 * An integer N is given, representing the area of some rectangle.
 * 
 * The area of a rectangle whose sides are of length A and B is A * B, and the
 * perimeter is 2 * (A + B).
 * 
 * The goal is to find the minimal perimeter of any rectangle whose area equals
 * N. The sides of this rectangle should be only integers.
 * 
 * For example, given integer N = 30, rectangles of area 30 are:
 * 
 * (1, 30), with a perimeter of 62, (2, 15), with a perimeter of 34, (3, 10),
 * with a perimeter of 26, (5, 6), with a perimeter of 22. Write a function:
 * 
 * class Solution { public int solution(int N); }
 * 
 * that, given an integer N, returns the minimal perimeter of any rectangle
 * whose area is exactly equal to N.
 * 
 * For example, given an integer N = 30, the function should return 22, as
 * explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..1,000,000,000].
 */
public class MinPerimeterRectangle {

    public int solution(int n) {
        java.util.Collection<Integer> divisors = divisors(n, (l, d) -> l.add(d));

        System.out.printf("divisors %s ", divisors);

        if (divisors.size() > 1) {
            java.util.List<Integer> list = new java.util.ArrayList<>(divisors);
            int middle = (int) Math.floor(list.size() / 2);
            return calculatePerimeter(list.get(middle).intValue(), list.get(middle - 1).intValue());
        } else {
            return calculatePerimeter(1, 1);
        }

    }

    int calculatePerimeter(int a, int b) {
        return 2 * (a + b);
    }

    java.util.Collection<Integer> divisors(int n,
            java.util.function.BiConsumer<java.util.Collection<Integer>, Integer> consumer) {
        int i = 1;
        java.util.Set<Integer> _divisors = new java.util.TreeSet<>();

        if (n == 1) {
            return java.util.Arrays.asList(n);
        }
        while (i * i < n) {

            if (n % i == 0) {
                // _divisors.add(i);
                consumer.accept(_divisors, i);

                if (i != n / i) {
                    consumer.accept(_divisors, n / i);
                    // _divisors.add(n / i);
                }
            }
            i++;
        }
        return _divisors;

    }

    public static void main(String[] args) {
        // 100,000,000-> 40000
        // 36-> 26
        // 1-> 4

        int n = 1;
        System.out.printf("\n%s of %d is %s \n", MinPerimeterRectangle.class.getName(), n,
                new MinPerimeterRectangle().solution(n));

        // IntStream.range(1, 100).forEach(n -> {
        // System.out.printf("%s of %d is %s \n", MinPerimeterRectangle.class.getName(),
        // n,
        // new MinPerimeterRectangle().solution(n));
        // });
    }
}