import java.util.Arrays;

/**
 * E300_Longest_Increasing_Subsequence
 */
public class E300_Longest_Increasing_Subsequence {

    /*
     * Runtime: 99 ms, faster than 28.52% of Java online submissions for Longest
     * Increasing Subsequence.
     * Memory Usage: 44.4 MB, less than 55.55% of Java online submissions for
     * Longest Increasing Subsequence.
     * Show off your acceptance:
     * 
     *  O(n^2)
     */
    public int lengthOfLIS(int[] nums) {

        if (nums.length == 1)
            return 1;

        int dp[] = new int[nums.length];
        dp[nums.length - 1] = 1;
        int maxFinal = 0;
        for (int i = nums.length - 2; i >= 0; i--) {

            int max = 0;

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] < nums[j] && max < dp[j]) {
                    max = dp[j];
                }
            }

            dp[i] = max + 1;
            if (maxFinal < dp[i]) {
                maxFinal = dp[i];
            }
        }
        return maxFinal;
    }


    public int lengthOfLISV2(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;
    
    for(int x : nums) {
        int i = Arrays.binarySearch(dp,0,len,x);
        if(i<0) i=~i;
        
        dp[i] = x;
        if(i==len)len++;
    }
    
    return len;
}
}