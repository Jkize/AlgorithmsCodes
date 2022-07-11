/**
 * E756_Easy_Min_Cost_Climbing_Stairs
 */
public class E756_Easy_Min_Cost_Climbing_Stairs {

    /**
     * Runtime: 2 ms, faster than 32.42% of Java online submissions for Min Cost
     * Climbing Stairs.
     * Memory Usage: 43.8 MB, less than 42.71% of Java online submissions for Min
     * Cost Climbing Stairs.
     * 
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {

        for (int i = cost.length - 3; i >= 0; i--) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }

        return Math.min(cost[0], cost[1]);
    }
}