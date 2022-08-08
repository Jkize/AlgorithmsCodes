import java.util.Stack;

/**
 * E20_Easy_Valid_Parentheses
 */
public class E20_Easy_Valid_Parentheses {

    /**
     * Runtime: 2 ms, faster than 90.79% of Java online submissions for Valid
     * Parentheses.
     * Memory Usage: 42.3 MB, less than 33.29% of Java online submissions for Valid
     * Parentheses.
     * 
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;

                default:
                    stack.add(c);
                    break;
            }
        }

        return stack.isEmpty();

    }

    /**
     * It's not my solution
     * 
     * https://leetcode.com/problems/valid-parentheses/discuss/2384091/Java-Solution-Using-Only-Stack-with-Explanation
     */
    public boolean isValid2(String s) {

        Stack<Character> stack = new Stack<>();

        for (Character ch : s.toCharArray()) {

            if (ch == '(')
                stack.push(')');

            else if (ch == '[')
                stack.push(']');

            else if (ch == '{')
                stack.push('}');

            else if (stack.isEmpty() || stack.pop() != ch)
                return false;

        }

        return stack.isEmpty();
    }
}