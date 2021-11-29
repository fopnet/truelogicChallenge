package codility;

/**
 * A binary gap within a positive integer N is any maximal sequence of
 * consecutive zeros that is surrounded by ones at both ends in the binary
 * representation of N.
 * 
 * For example, number 9 has binary representation 1001 and contains a binary
 * gap of length 2. The number 529 has binary representation 1000010001 and
 * contains two binary gaps: one of length 4 and one of length 3. The number 20
 * has binary representation 10100 and contains one binary gap of length 1. The
 * number 15 has binary representation 1111 and has no binary gaps. The number
 * 32 has binary representation 100000 and has no binary gaps.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int N); }
 * 
 * that, given a positive integer N, returns the length of its longest binary
 * gap. The function should return 0 if N doesn't contain a binary gap.
 * 
 * For example, given N = 1041 the function should return 5, because N has
 * binary representation 10000010001 and so its longest binary gap is of length
 * 5. Given N = 32 the function should return 0, because N has binary
 * representation '100000' and thus no binary gaps.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..2,147,483,647].
 * 
 * 51712 -> 2
 * 
 * 561892 -> 3
 * 
 * 1610612737 -> 28
 */
public class BinaryGap {
    private boolean toggled = false;
    private int max = 0;
    private String binary;

    public int solution(int n) {
        java.math.BigInteger bi = java.math.BigInteger.valueOf(n);
        String binary = new java.math.BigInteger(bi.toByteArray()).toString(2);

        System.out.printf("BinaryGap bits is %s \n", binary);

        binary.chars().reduce(0, (acc, c) -> {

            boolean canCount = canCount(c);
            if (canCount) {
                ++acc;
            }

            acc = toggle(c, acc);

            return acc;

        });

        return max;
    }

    private int toggle(int c, int acc) {
        if (c == 49) {

            if (toggled) {
                if (acc > 0) {
                    this.max = Math.max(max, acc);
                    return 0;
                } else {
                    return acc;
                }
            }

            toggled = !toggled;

        }

        return acc;
    }

    private boolean canCount(int c) {
        return this.toggled && c == 48;
    }

    public static void main(String[] args) {
        // 51712 -> 2
        // 561892 -> 10001001001011100100 -> 3
        // 1610612737 -> 28
        // 6291457 -> 11000000000000000000001 -> 20
        // 1376796946 -> 1010010000100000100000100010010 -> 5

        int n = 1376796946;
        System.out.printf("BinaryGap of %d is %d \n", n, new BinaryGap().solution(n));
    }
}