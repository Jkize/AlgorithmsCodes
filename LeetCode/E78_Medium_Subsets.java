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

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ttl = new ArrayList<>();
        ttl.add(new ArrayList<>());
        dfs(ttl, 0, nums, 0);
        return ttl;
    }

    public static void dfs(List<List<Integer>> ttl, int postCrrNode, int[] nums, int posStart) {

        for (int i = posStart; i < nums.length; i++) {
            List<Integer> copy = new ArrayList<>(ttl.get(postCrrNode));
            copy.add(nums[i]);
            ttl.add(copy);
            dfs(ttl, ttl.size() - 1, nums, i + 1);
        }

    }

}
