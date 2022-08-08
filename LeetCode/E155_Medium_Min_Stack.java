import java.util.Stack;

public class E155_Medium_Min_Stack {

    /*
     * Runtime: 9 ms, faster than 42.75% of Java online submissions for Min Stack.
     * Memory Usage: 48.4 MB, less than 62.59% of Java online submissions for Min
     * Stack.
     */
    static class MinStack {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val < minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {

            return minStack.peek();

        }
    }

 }
