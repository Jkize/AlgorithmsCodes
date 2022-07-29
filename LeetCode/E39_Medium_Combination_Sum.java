import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E39_Medium_Combination_Sum {

    public static void main(String[] args) {
        int[] candidates = { 1, 2, 3 };
        E39_Medium_Combination_Sum sol = new E39_Medium_Combination_Sum();
        List<List<Integer>> res = sol.combinationSum(candidates, 3);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new LinkedList<>(), candidates, 0, 0, target);
        return res;
    }

    public void dfs(List<List<Integer>> res, LinkedList<Integer> current, int[] candidates, int i, int sum,
            int target) {

        if (sum == target) {
            res.add(new ArrayList<>(current));
            return;
        }

        if (i == candidates.length || sum > target)
            return;

        current.add(candidates[i]);
        dfs(res, current, candidates, i, sum + candidates[i], target);
        current.removeLast();
        dfs(res, current, candidates, i + 1, sum, target);
    }
}
