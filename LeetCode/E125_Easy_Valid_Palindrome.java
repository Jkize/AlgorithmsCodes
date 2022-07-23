public class E125_Easy_Valid_Palindrome {
    /**
     * Runtime: 3 ms, faster than 98.83% of Java online submissions for Valid
     * Palindrome.
     * Memory Usage: 43.7 MB, less than 58.02% of Java online submissions for Valid
     * Palindrome.
     * 
     */
    public boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        while (r > l) {

            char cL = s.charAt(l);
            char cR = s.charAt(r);

            while (!Character.isLetterOrDigit(cR) && r > l) {
                r--;
                cR = s.charAt(r);
            }

            while (!Character.isLetterOrDigit(cL) && r > l) {
                l++;
                cL = s.charAt(l);
            }
            if (Character.toLowerCase(cL) != Character.toLowerCase(cR)) {
                return false;
            }
            r--;
            l++;

        }

        return true;
    }
}
