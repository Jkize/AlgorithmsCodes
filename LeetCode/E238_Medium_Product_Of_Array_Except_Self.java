public class E238_Medium_Product_Of_Array_Except_Self {

    /**
     * Runtime: 2 ms, faster than 88.71% of Java online submissions for Product of
     * Array Except Self.
     * Memory Usage: 58.2 MB, less than 23.94% of Java online submissions for
     * Product of Array Except Self.
     * 
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int res[] = new int[nums.length];

        for (int i = 0, temp = 1; i < n; i++) {
            res[i] = temp;
            temp *= nums[i];
        }

        for (int i = n - 1, temp = 1; i >= 0; i--) {
            res[i] = res[i] * temp;
            temp *= nums[i];
        }

        return res;
    }
}
