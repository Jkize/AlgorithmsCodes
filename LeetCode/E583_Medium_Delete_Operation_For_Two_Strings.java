public class E583_Medium_Delete_Operation_For_Two_Strings {
    public int minDistance(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];

        for (int i = text1.length() - 1; i >= 0; i--) {

            for (int j = text2.length() - 1; j >= 0; j--) {

                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }

            }
        }

        return text1.length() + text2.length() - 2 * dp[0][0];
    }
}
