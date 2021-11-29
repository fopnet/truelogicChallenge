package challenges;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DistanceBetween {
    private int a;
    private int b;
    private boolean invalid;

    DistanceBetween(int a, int b) {
        this.a = a;
        this.b = b;
        this.invalid = false;
    }

    Integer getDistance() {
        return Integer.valueOf(Math.abs(a - b));
    }

    boolean isValid() {
        return !invalid;
    }

    void invalidate() {
        this.invalid = true;
    }

    public String toString() {
        return String.format("(%n,%n)", a, b);
    }

    public static void main(String[] args) {
        // test 1
        Integer[] testArray1 = { 3, 9, 50, 15, 99, 7, 98, 65 };
        // assert result == 1;
        int result = closestDistanceBetweenNumbers(testArray1);
        assertResult(1, result);

        // test 2
        Integer[] testArray2 = { 56, 785, 8, 45, 1, 90, 150 };
        // assert result == 7;
        result = closestDistanceBetweenNumbers(testArray2);
        assertResult(7, result);

    }

    static void assertResult(int expected, int result) {
        System.out.println("Result ".concat(String.valueOf(result)));
        assert result == expected;
    }

    public static int closestDistanceBetweenNumbers(Integer[] numbers) {
        return IntStream.range(0, numbers.length).mapToObj(i -> IntStream.range(0, numbers.length).mapToObj(j -> {
            DistanceBetween d = new DistanceBetween(numbers[i], numbers[j]);
            if (i == j) {
                d.invalidate();
            }
            return d;

        }).toArray(DistanceBetween[]::new)).flatMap(Stream::of).filter(DistanceBetween::isValid)
                .map(DistanceBetween::getDistance).reduce(Integer.MAX_VALUE, Integer::min);

    }
}