import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E40_Medium_Combination_SumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ttl = new ArrayList<>();
        ttl.add(new ArrayList<>());

        Arrays.sort(candidates);
        dfs(ttl, candidates, 0, new ArrayList<>(), target);

        return ttl;
    }

    public void dfs(List<List<Integer>> ttl, int[] nums, int posStart, List<Integer> bt, int target) {

        for (int i = posStart; i < nums.length; i++) {
            bt.add(nums[i]);
            target -= nums[i];
            if (target <= 0) {
                if (target == 0)
                    ttl.add(new ArrayList<>(bt));
                return;
            }

            dfs(ttl, nums, i + 1, bt, target);
            int dt = bt.remove(bt.size() - 1);
            target += dt;
            while (i < nums.length - 1 && dt == nums[i + 1]) {
                i++;
            }
        }

    }
}
