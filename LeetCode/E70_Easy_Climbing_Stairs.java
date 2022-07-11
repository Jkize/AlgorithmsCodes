public class E70_Easy_Climbing_Stairs {
/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
Memory Usage: 40.8 MB, less than 49.72% of Java online submissions for Climbing Stairs.
 * @param n
 * @return
 */

    public int climbStairs(int n) {

        int f0 = 1;
        int f1 = 1;

        for (int i = 2; i <= n; i++) {
            int nw = f1 + f0;
            f0 = f1;
            f1 = nw;

        }

        return f1;
    }
}
