import java.util.HashMap;

public class E992_Hard_Subarrays_with_K_Different_Integers {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();

        System.out.println(map.merge(1, 1, Integer::sum));
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        int res = 0, discAc = 0, r = 0, l = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < nums.length) {

            if (map.merge(nums[r++], 1, Integer::sum) == 1) {
                discAc++;
            }
            if (discAc == k)
                res++;

            while ( (discAc > k || r == nums.length) && l!=nums.length) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l++]) == 0) {
                    discAc--;
                }
                if (discAc == k)
                    res++;
            }

        }

        return res;

    }

}
