public class E209_Medium_Size_SubArray_Sum {

    public static void main(String[] args) {
        int nums[] = { 2, 3, 1, 2, 4, 3 };
        E209_Medium_Size_SubArray_Sum sol = new E209_Medium_Size_SubArray_Sum();
        sol.minSubArrayLen(50, nums);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int l = 0, r = 0;

        while (r < nums.length) {
            if (sum < target) {
                sum += nums[r++];
            }
            while (sum >= target) {
                minLength = Math.min(minLength, r - l);
                sum -= nums[l++];
            }

        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
