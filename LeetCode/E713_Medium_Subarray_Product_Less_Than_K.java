public class E713_Medium_Subarray_Product_Less_Than_K {

    public static void main(String[] args) {
        E713_Medium_Subarray_Product_Less_Than_K sol = new E713_Medium_Subarray_Product_Less_Than_K();

        sol.numSubarrayProductLessThanK(new int[] { 1, 1, 100, 100 }, 100);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, r = 0, left = 0;
        
        for(int right=0; right<nums.length;right++){
            prod*=nums[right];
            while(prod>=k)
                prod/=nums[left++];
            r+= right-left+1;
            
        }
        
        
        return r;
    }
}
