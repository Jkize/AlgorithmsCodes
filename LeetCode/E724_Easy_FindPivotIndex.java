/**
 * E724_Easy_FindPivotIndex
 * Link: https://leetcode.com/problems/find-pivot-index/
 */
public class E724_Easy_FindPivotIndex {

    public int pivotIndex(int[] nums) {
      
        int sumLeft=0;
        int sum=0;
        for(int n:nums)sum+=n;
        
        for(int i=0; i<nums.length; i++){
            if(sumLeft== sum-nums[i]-sumLeft ){
                return i;
            }
            sumLeft+=nums[i];
        }
        
        return -1;
        
    }
    
}