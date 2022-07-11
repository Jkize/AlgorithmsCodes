/**
 * E409_Easy_LongestPalindrome
 * Runtime: 6 ms, faster than 52.49% of Java online submissions for Longest
 * Palindrome.
 * Memory Usage: 42.1 MB, less than 67.49% of Java online submissions for
 * Longest Palindrome.
 */
import java.util.HashMap;
import java.util.Map;
public class E409_Easy_LongestPalindrome {
    public int longestPalindrome(String s) {
        int total = 0;
        HashMap<Character, Integer> count = new HashMap<>();

        for (Character c : s.toCharArray()) {
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);

            } else {
                count.put(c, 1);
            }
        }
        int aux = 0;
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            total += entry.getValue();
            if (entry.getValue() % 2 != 0) {
                total -= 1;
                aux = 1;
            }
        }
        return total + aux;
    }

}