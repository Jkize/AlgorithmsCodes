public class E392_Easy_isSubsequence {

    /*
     * Runtime: 2 ms, faster than 46.47% of Java online submissions for Is
     * Subsequence.
     * Memory Usage: 42.1 MB, less than 50.67% of Java online submissions for Is
     * Subsequence.
     */
    public boolean isSubsequence(String s, String t) {

        if (s.length() == 0) {
            return true;
        }

        int cont = 0;
        Character f = s.charAt(0);
        for (int j = 0, i = 0; j < t.length(); j++) {

            if (f == t.charAt(j)) {
                cont++;
                i++;
                if (i >= s.length())
                    break;
                f = s.charAt(i);
            }

        }
        return cont == s.length();

    }

    /*
     * Runtime: 2 ms, faster than 46.47% of Java online submissions for Is
     * Subsequence.
     * Memory Usage: 42 MB, less than 50.67% of Java online submissions for Is
     * Subsequence.
     */
    public boolean isSubsequence2(String s, String t) {

        int i = 0;

        for (int j = 0; j < t.length() && i < s.length(); j++) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

        }
        return i == s.length();

    }
}
