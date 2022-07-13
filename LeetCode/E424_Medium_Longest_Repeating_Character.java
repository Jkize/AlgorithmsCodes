import java.util.Comparator;
import java.util.TreeMap;

/**
 * E424_Medium_Longest_Repeating_Character
 */
public class E424_Medium_Longest_Repeating_Character {

    public static void main(String[] args) {
        E424_Medium_Longest_Repeating_Character b = new E424_Medium_Longest_Repeating_Character();
        b.characterReplacement("AABABBA", 1);
    }

    public int characterReplacement(String s, int k) {
        int res = 0, l = 0, maxF = 0;

        int[] map = new int[26];
        for (int r = 0; r < s.length(); r++) {
            maxF = Math.max(maxF, ++map[s.charAt(r) - 'A']);

            while ((r - l + 1) - maxF > k) {
                map[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);

        }

        return res;
    }
}