import java.util.HashMap;
import java.util.HashSet;

public class E3_Medium_LongestSubstringWithoutRepe {

    // Sliding WIndow
    public int lengthOfLongestSubstringV3(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0, res = 0;
        for (int r = 0; r < s.length(); r++) {
            Character c = s.charAt(r);
            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            res = Math.max(r - l + 1, res);
        }
        return res;
    }

    /**
     * Runtime: 216 ms, faster than 10.63% of Java online submissions for Longest
     * Substring Without Repeating Characters.
     * Memory Usage: 117.6 MB, less than 6.96% of Java online submissions for
     * Longest Substring Without Repeating Characters.
     * 
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                max = (max < map.size()) ? map.size() : max;
                i = map.get(c);
                map = new HashMap<>();

            } else {
                map.put(c, i);
            }
        }

        max = (max < map.size()) ? map.size() : max;
        return max;

    }

    /**
     * Best!!
     * Runtime: 5 ms, faster than 92.27% of Java online submissions for Longest
     * Substring Without Repeating Characters.
     * Memory Usage: 42.7 MB, less than 87.51% of Java online submissions for
     * Longest Substring Without Repeating Characters.
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    /**
     * Runtime: 2 ms, faster than 99.99% of Java online submissions for Longest
     * Substring Without Repeating Characters.
     * Memory Usage: 42.5 MB, less than 91.35% of Java online submissions for
     * Longest Substring Without Repeating Characters.
     */
    public int lengthOfLongestSubstringv4(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }

}