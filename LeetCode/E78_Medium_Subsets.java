import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 1 ms, faster than 88.36% of Java online submissions for Subsets.
 * Memory Usage: 43.3 MB, less than 51.61% of Java online submissions for
 * Subsets.
 * Next challenges:
 * https://leetcode.com/problems/subsets/
 */
public class E78_Medium_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ttl = new ArrayList<>();
        ttl.add(new ArrayList<>());

        dfs(ttl, nums, 0, new ArrayList<>());

        return ttl;
    }

    public void dfs(List<List<Integer>> ttl, int[] nums, int posStart, List<Integer> bt) {

        for (int i = posStart; i < nums.length; i++) {
            bt.add(nums[i]);
            ttl.add(new ArrayList<>(bt));
            dfs(ttl, nums, i + 1, bt);
            bt.remove(bt.size() - 1);
        }

    }

}
