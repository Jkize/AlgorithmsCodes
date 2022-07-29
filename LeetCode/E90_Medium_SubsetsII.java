import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * E90_Medium_SubsetsII
 */
public class E90_Medium_SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ttl = new ArrayList<>();
        ttl.add(new ArrayList<>());

        Arrays.sort(nums);
        dfs(ttl, nums, 0, new ArrayList<>());

        return ttl;
    }

    public void dfs(List<List<Integer>> ttl, int[] nums, int posStart, List<Integer> bt) {

        for (int i = posStart; i < nums.length; i++) {
            bt.add(nums[i]);
            ttl.add(new ArrayList<>(bt));
            dfs(ttl, nums, i + 1, bt);
            int dt = bt.remove(bt.size() - 1);
            while (i < nums.length - 1 && dt == nums[i + 1]) {
                i++;
            }
        }

    }
}