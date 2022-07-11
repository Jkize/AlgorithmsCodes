/**
 * E509_Easy_FibonacciNumber
 */
public class E509_Easy_FibonacciNumber {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int f0 = 0;
        int f1 = 1;
        for (int i = 1; i < n; i++) {
            int fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return f1;
    }
}