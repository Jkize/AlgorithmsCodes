import java.util.*;

public class E347_Medium_Tok_K_Frequent_Elements {

    /**
     * Runtime: 10 ms, faster than 96.05% of Java online submissions for Top K
     * Frequent Elements.
     * Memory Usage: 49.6 MB, less than 81.97% of Java online submissions for Top K
     * Frequent Elements.
     * 
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i : nums) {
            pos.merge(i, 1, Integer::sum);
        }

        ArrayList<Integer> count[] = new ArrayList[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : pos.entrySet()) {
            if (count[entry.getValue()] == null) {
                count[entry.getValue()] = new ArrayList<>();
            }
            count[entry.getValue()].add((entry.getKey()));
        }
        int p = 0;
        int[] res = new int[k];

        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] == null)
                continue;
            for (int num : count[i]) {
                res[p++] = num;
                if (p == k)
                    return res;
            }
        }

        return res;

    }
}
