public class E33_Medium_Search_In_Rotated_Sorted_Array {

    public static void main(String[] args) {
        E33_Medium_Search_In_Rotated_Sorted_Array sol = new E33_Medium_Search_In_Rotated_Sorted_Array();

        sol.search(new int[] {8,9,2,3,4}, 9);

    }
 
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            if ( (target <= nums[r] && (target > nums[mid] || nums[mid] > nums[r] )  ) || (target>nums[l] && target>nums[mid] && nums[mid]>=nums[r]) ) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return -1;
    }
}
