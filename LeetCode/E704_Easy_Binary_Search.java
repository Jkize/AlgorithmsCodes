/**
 * E704_Easy_Binary_Search
 * https://leetcode.com/problems/binary-search
 * 
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary
 * Search.
 * Memory Usage: 54.3 MB, less than 53.57% of Java online submissions for Binary
 * Search.
 */
public class E704_Easy_Binary_Search {

    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < nums[mid])
                hi = mid - 1;
            else if (target > nums[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}