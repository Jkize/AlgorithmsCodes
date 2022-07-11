/**
 * Runtime: 3 ms, faster than 65.15% of Java online submissions for Best Time to
 * Buy and Sell Stock.
 * Memory Usage: 83.8 MB, less than 46.58% of Java online submissions for Best
 * Time to Buy and Sell Stock.
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
 */
public class E121_Easy_Best_Time_To_Buy {
    public int maxProfit(int[] prices) {

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }
}
