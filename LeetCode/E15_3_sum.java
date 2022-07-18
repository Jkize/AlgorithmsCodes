import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * E15_3_sum
 */
public class E15_3_sum {

    public static void main(String[] args) {
        E15_3_sum sol = new E15_3_sum();
        sol.threeSum(new int[] { -1, 0, 1 });
    }

    // Tree Pointers
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the given array
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int idx = 0; idx + 2 < nums.length; idx++) {
            // Skip all duplicates from left
            // num1Idx>0 ensures this check is made only from 2nd element onwards
            if (idx > 0 && nums[idx] == nums[idx - 1]) {
                continue;
            }

            int l = idx + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[idx];
                if (sum == 0) {
                    // Add triplet to result
                    result.add(Arrays.asList(nums[idx], nums[l], nums[r]));

                    r--;

                    // Skip all duplicates from right
                    while (l < r && nums[r] == nums[r + 1])
                        r--;
                } else if (sum > 0) {
                    // Decrement num3Idx to reduce sum value
                    r--;
                } else {
                    // Increment num2Idx to increase sum value
                    l++;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSumv2(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1])
                            lo++;
                        while (lo < hi && num[hi] == num[hi - 1])
                            hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return res;
    }
}