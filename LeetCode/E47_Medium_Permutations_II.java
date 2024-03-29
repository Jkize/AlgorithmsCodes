
import java.util.*;

public class E47_Medium_Permutations_II {

    public static void main(String[] args) {
        System.out.println(1%1);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        LinkedList<Integer> _nums = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            _nums.add(nums[i]);
        }
        return permutation(_nums);

    }

    public List<List<Integer>> permutation(LinkedList<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.size() == 1) {
            res.add(new ArrayList<>(nums));
            return res;
        }

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.pollFirst();

            List<List<Integer>> permutations = permutation(nums);
            for (List<Integer> perm : permutations) {
                perm.add(num);
            }

            res.addAll(permutations);

            nums.addLast(num);
 
            while (i + 1 < nums.size() && num == nums.getFirst() ) {
                nums.add(nums.poll());
                i++;
            }

        }

        return res;
    }
}
