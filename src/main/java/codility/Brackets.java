package codility;

/**
 * A string S consisting of N characters is considered to be properly nested if
 * any of the following conditions is true:
 * 
 * S is empty; S has the form "(U)" or "[U]" or "{U}" where U is a properly
 * nested string; S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); }
 * 
 * that, given a string S consisting of N characters, returns 1 if S is properly
 * nested and 0 otherwise.
 * 
 * For example, given S = "{[()()]}", the function should return 1 and given S =
 * "([)()]", the function should return 0, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..200,000]; string S consists only of the
 * following characters: "(", "{", "[", "]", "}" and/or ")".
 * 
 * References:
 * https://www.geeksforgeeks.org/check-balanced-parentheses-expression-o1-space/
 * https://www.geeksforgeeks.org/check-for-balanced-parenthesis-without-using-stack/
 * 
 */
public class Brackets {
    private java.util.Stack<Character> pilha;

    public int solution(String buffer) {

        pilha = new java.util.Stack<>();

        try {
            if (buffer == null || buffer.length() % 2 != 0) {
                throwNotBalanced();
            }
            buffer = sanitize(buffer);
            buffer.codePoints().forEach(c -> {
                if (canPush(c))
                    pilha.push(Character.valueOf((char) c));
                else
                    tryPop(c);
            });

            return pilha.isEmpty() ? 1 : 0;
        } catch (RuntimeException re) {
            return 0;
        }
    }

    private void tryPop(int code) {
        char close = (char) code;
        if (pilha.isEmpty() || !isPair(pilha.peek(), close)) {
            throwNotBalanced();
        }
        pilha.pop();
    }

    private void throwNotBalanced() {
        throw new RuntimeException("Not balanced");
    }

    private boolean isPair(char open, char close) {
        if (Character.valueOf(open).equals('{') && Character.valueOf(close).equals('}'))
            return true;
        if (Character.valueOf(open).equals('[') && Character.valueOf(close).equals(']'))
            return true;
        if (Character.valueOf(open).equals('(') && Character.valueOf(close).equals(')'))
            return true;

        return false;
    }

    private boolean canPush(int code) {
        char open = (char) code;
        return java.util.Arrays.asList('{', '[', '(').contains(open);
    }

    public String sanitize(String str) {
        // return s.replaceAll("(\\(\\))|(\\[\\])|(\\{\\})", "");
        while (str.contains("()") || str.contains("[]") || str.contains("{}")) {
            str = str.replaceAll("\\(\\)", "").replaceAll("\\[\\]", "").replaceAll("\\{\\}", "");
        }

        return str;
    }

    public static void main(String[] args) {
        // {[()()]} -> 1
        // ([)()]-> 0
        // ][-> 0

        String s = ")(";
        System.out.printf("\n%s :: %s is balanced %d\n", Brackets.class.getName(), s, new Brackets().solution(s));

        // System.out.println(new Brackets().sanitize(s));
    }
}