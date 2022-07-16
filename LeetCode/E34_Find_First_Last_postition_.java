public class E34_Find_First_Last_postition_ {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First
     * and Last Position of Element in Sorted Array.
     * Memory Usage: 47 MB, less than 70.86% of Java online submissions for Find
     * First and Last Position of Element in Sorted Array.
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }
}
