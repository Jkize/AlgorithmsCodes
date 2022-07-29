import java.util.*;

public class E22_Medium_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), n, 0, 0);
        return res;

    }

    public void backtrack(List<String> res, StringBuilder str, int n, int open, int close) {

        if (open == n && close == n) {
            res.add(str.toString());
            return;
        }

        if (open < n) {
            str.append("(");
            backtrack(res, str, n, open + 1, close);
            str.deleteCharAt(str.length() - 1);
        }
        if (close < open) {
            str.append(")");
            backtrack(res, str, n, open, close + 1);
            str.deleteCharAt(str.length() - 1);
        }

    }

}
