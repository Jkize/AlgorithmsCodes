public class E242_Easy_Valid_Anagram {

    public boolean isAnagram(String s, String p) {

        if (s.length() != p.length()) {
            return false;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < pCount.length; i++) {
            if (sCount[i] != pCount[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        E242_Easy_Valid_Anagram sol = new E242_Easy_Valid_Anagram();
        sol.isAnagramV2("anagrams", "nagarams");
    }

    public boolean isAnagramV2(String s, String p) {

        if (s.length() != p.length()) {
            return false;
        }
        int count = 0;
        int[] alpha = new int[26];

        for (int i = 0; i < p.length(); i++) {
            count += ++alpha[s.charAt(i) - 'a'] - --alpha[p.charAt(i) - 'a'];
        }

        return count == s.length();
    }
}
