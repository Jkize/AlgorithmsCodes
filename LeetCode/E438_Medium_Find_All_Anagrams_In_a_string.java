import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class E438_Medium_Find_All_Anagrams_In_a_string {

    public static void main(String[] args) {
        E438_Medium_Find_All_Anagrams_In_a_string sol = new E438_Medium_Find_All_Anagrams_In_a_string();

        sol.findAnagrams("cbaebabacd", "abc");
    }

    /**
     * Runtime: 87 ms, faster than 22.36% of Java online submissions for Find All
     * Anagrams in a String.
     * 
     * Memory Usage: 55 MB, less than 9.13% of Java online submissions for Find All
     * Anagrams in a String.
     */
    public List<Integer> findAnagrams(String s, String p) {

        if (p.length() > s.length()) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> pCount = new HashMap<>();
        HashMap<Character, Integer> sCount = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {

            pCount.merge(p.charAt(i), 1, Integer::sum);
            pCount.merge(s.charAt(i), 1, Integer::sum);
        }

        if (pCount.equals(sCount)) {
            res.add(0);
        }
        int sl = 1;
        for (int i = p.length(); i < s.length(); i++) {
            Character cS = s.charAt(i);

            if (sCount.containsKey(s.charAt(sl))) {
                sCount.put(s.charAt(sl), sCount.get(s.charAt(sl)) - 1);
            }

            sCount.put(cS, (sCount.get(cS) != null) ? sCount.get(cS) + 1 : 1);

            if (sCount.get(s.charAt(sl)) == 0) {
                sCount.remove(s.charAt(sl));
            }
            sl++;
            if (pCount.equals(sCount)) {
                res.add(sl);
            }

        }

        return res;
    }

    /**
     * https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/146443/Java-Code-Beats-98.76-with-Explanation
     */
    public List<Integer> findAnagramsOther(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int cntMatch = 0;
        int[] pMap = new int[256];
        for (char c : p.toCharArray()) {
            pMap[c]++;
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char sChar = s.charAt(right);
            pMap[sChar]--;
            if (pMap[sChar] + 1 > 0) {
                cntMatch++;
            }
            while (cntMatch == p.length()) {
                if (right - left + 1 == p.length()) {
                    result.add(left);
                }
                sChar = s.charAt(left);
                pMap[sChar]++;
                if (pMap[sChar] - 1 >= 0) {
                    cntMatch--;
                }
                left++;
            }
        }
        return result;
    }

    public List<Integer> findAnagramsv3(String s, String p) {
        int[] charCount = new int[26];

        for (int i = 0; i < p.length(); i++)
            charCount[p.charAt(i) - 'a']++;

        List<Integer> retList = new ArrayList<>();

        // A variation of sliding window: The left and right end represent the end of a
        // window.
        // toVisit gives # elements remaining to be visited in the window, till we slide
        // the window.
        int left = 0, right = 0, toVisit = p.length();
        while (right < s.length()) {
            // If char at right end of window is present in p(charCount)
            if (charCount[s.charAt(right) - 'a'] >= 1) {
                toVisit--;
            }
            charCount[s.charAt(right) - 'a']--; // Reduce count of char at right end.
            right++; // Increment right end.

            if (toVisit == 0)
                retList.add(left);

            // If you have traversed a window completely. Once you've traversed the first
            // p.length() elements
            // ie. the first window this would always be true,
            // this is here just so that we completely scan our first window, without
            // incrementing left.
            if (right - left == p.length()) {
                if (charCount[s.charAt(left) - 'a'] >= 0) {
                    // This would increment toVisit for characters which were found at right end and
                    // were
                    // present in p(charCount) because of which we decremented toVisit in the first
                    // if block
                    // and then some characters of p were not found in the window so we need to
                    // increment.
                    toVisit++;
                }
                charCount[s.charAt(left) - 'a']++;
                left++; // Just to slide the window.
            }
        }
        return retList;
    }
}
