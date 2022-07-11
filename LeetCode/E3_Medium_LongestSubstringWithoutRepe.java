import java.util.HashMap; 

public class E3_Medium_LongestSubstringWithoutRepe {

 
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
     * Runtime: 14 ms, faster than 45.41% of Java online submissions for Longest
     * Substring Without Repeating Characters.
     * Memory Usage: 44.8 MB, less than 55.89% of Java online submissions for
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

}