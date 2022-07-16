public class E153_Medium_Find_Minimum_In_Rotated_Sorted_Array {
    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length - 1;
        int target = Integer.MIN_VALUE;

        int pos = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            pos = l;

            if ((target <= nums[r] && (target > nums[mid] || nums[mid] > nums[r]))
                    || (target > nums[l] && target > nums[mid] && nums[mid] >= nums[r])) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return nums[pos];
    }
}
