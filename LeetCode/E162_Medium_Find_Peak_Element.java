public class E162_Medium_Find_Peak_Element {
/*
         5   5                           5
        / \ / \                         / \
       4   4   4                       4  -∞
      /         \                     /
     3           3           3       3
    /             \         / \     /
   2               2       2   2   2
  /                 \     /     \ /
-∞                   1   1       1
                      \ /
                       0                      
   0 1 2 3 4 5 6 7 8 910111213141516171819 indices
   2,3,4,5,4,5,4,3,2,1,0,1,2,3,2,1,2,3,4,5 (20 nums)
   l                 m                   r l=0, m=9, r=19
   l       m         r                     l=0, m=4, r= 9
             l   m   r                     l=5, m=7, r= 9
             l>m r                         l=5, m=6, r= 7
  return n[l] > n[l + 1])? l : r


 */


public int findPeakElement(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            r = mid;
        else
            l = mid + 1;
    }
    return l;
}
}
