import java.util.*;

public class E139_Medium_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[wordDict.size() + 1];
        dp[wordDict.size()] = true;

        for (int i = wordDict.size() - 1; i >= 0; i--) {

            for (String w : wordDict) {

                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }

                if (dp[i])
                    break;

            }
        }

        return dp[0];
    }
}
