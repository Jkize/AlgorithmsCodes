
import java.util.*;

public class E17_Letter_Combination_Of_a_phone_number {

    /**
     * Runtime: 1 ms, faster than 95.39% of Java online submissions for Letter
     * Combinations of a Phone Number.
     * Memory Usage: 42.8 MB, less than 44.40% of Java online submissions for Letter
     * Combinations of a Phone Number.
     * 
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        String lPhone[] = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> res = new ArrayList<>();
        combination(res, new StringBuilder(), lPhone, digits, 0);
        return res;
    }

    public void combination(List<String> res, StringBuilder current, String[] lPhone, String digits, int posInit) {

        if (current.length() == digits.length()) {
            res.add(current.toString());
            return;
        }

        String comb = lPhone[Integer.parseInt(digits.charAt(posInit) + "") - 2];
        for (char c : comb.toCharArray()) {
            current.append(c);
            combination(res, current, lPhone, digits, posInit + 1);
            current.deleteCharAt(current.length() - 1);
        }

    }
}
