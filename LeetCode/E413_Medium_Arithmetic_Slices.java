public class E413_Medium_Arithmetic_Slices {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Arithmetic
     * Slices.
     * Memory Usage: 41.9 MB, less than 50.02% of Java online submissions for
     * Arithmetic Slices.
     * 
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3)
            return 0;

        int cont = 0, r = 2, l = 0;
        int dif = nums[1] - nums[0];

        while (r < nums.length) {

            if (dif != nums[r] - nums[r - 1]) {
                dif = nums[r] - nums[r - 1];
                l = r - 1;
            } else if (r - l + 1 >= 3) {
                cont += r - l - 1;
            }

            r++;

        }

        return cont;
    }


    public int numberOfArithmeticSlicesV2(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }
}
