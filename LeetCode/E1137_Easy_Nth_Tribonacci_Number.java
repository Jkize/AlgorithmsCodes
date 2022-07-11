/*
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for N-th Tribonacci Number.
Memory Usage: 40.9 MB, less than 40.90% of Java online submissions for N-th Tribonacci Number.
 */
public class E1137_Easy_Nth_Tribonacci_Number {
    public int tribonacci(int n) {
        if (n == 0)
            return n;
        int f0 = 0;
        int f1 = 1;
        int f2 = 1;

        for (int i = 3; i <= n; i++) {
            int t = f0 + f1 + f2;
            f0 = f1;
            f1 = f2;
            f2 = t;
        }
        return f2;
    }
}
