public class E5_Medium_Longest_Palindromic_Substring {

    /**
     * Runtime: 19 ms, faster than 96.05% of Java online submissions for Longest
     * Palindromic Substring.
     * Memory Usage: 41.9 MB, less than 98.15% of Java online submissions for
     * Longest Palindromic Substring.
     * 
     * @param s
     * @return
     */

    public String longestPalindrome(String s) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int len = Math.max(lengthPalindrome(s, i, i), lengthPalindrome(s, i, i + 1));
            if (len > r - l + 1) {
                r = i + len / 2;
                l = i - (len - 1) / 2;
            }
        }

        return s.substring(l, r + 1);
    }

    public int lengthPalindrome(String s, int r, int l) {

        while (r < s.length() && l >= 0 && s.charAt(r) == s.charAt(l)) {
            l--;
            r++;
        }

        return r - l - 1;
    }

    public void abc(int ...abc){
        
    }
}
