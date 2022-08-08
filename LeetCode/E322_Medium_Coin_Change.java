import java.util.*;

public class E322_Medium_Coin_Change {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j:coins){
                if (i-j>=0)
                    dp[i]=Math.min(dp[i],dp[i-j]+1);
            }
        } 
        return dp[amount]==amount+1?-1:dp[amount];
    }
}