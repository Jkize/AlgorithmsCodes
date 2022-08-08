import java.util.Stack;

public class E150_Medium_Evaluate_Reverse_Polish_Notation {

    /*
     * Runtime: 11 ms, faster than 34.54% of Java online submissions for Evaluate
     * Reverse Polish Notation.
     * Memory Usage: 43.9 MB, less than 64.91% of Java online submissions for
     * Evaluate Reverse Polish Notation.
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int n;
        for (String st : tokens) {

            switch (st) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    n = stack.pop();
                    stack.push(stack.pop() - n);
                    break;
                case "/":
                    n = stack.pop();
                    stack.push(stack.pop() / n);
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                default:
                    stack.push(Integer.valueOf(st));
                    break;
            }

        }

        return stack.pop();
    }
}
