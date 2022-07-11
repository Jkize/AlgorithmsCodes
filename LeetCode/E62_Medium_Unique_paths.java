import java.util.Arrays;

public class E62_Medium_Unique_paths {
    public static void main(String[] args) {
        E62_Medium_Unique_paths sol = new E62_Medium_Unique_paths();
        sol.uniquePaths(5, 4);
    }

    /**
     * Best, less memory and simple
     */
    public int uniquePathsv2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    /*
     * This solution is very similar to mine. But it's a little better
     * The same logic
     */
    public int uniquePaths2(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     * 
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique
     * Paths.
     * Memory Usage: 41.6 MB, less than 13.12% of Java online submissions for Unique
     * Paths.
     */
    public int uniquePaths(int m, int n) {
        if (m == 1) {
            return 1;
        }
        if (m == 2) {
            return n;
        }

        m -= 2;
        int dp[] = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i + 1;
        }

        while (m != 0) {
            int _dp[] = new int[n];
            _dp[0] = 1;
            for (int i = 1; i < dp.length; i++) {
                _dp[i] = _dp[i - 1] + dp[i];
            }
            dp = _dp;
            --m;
        }

        return dp[dp.length - 1];
    }
}
