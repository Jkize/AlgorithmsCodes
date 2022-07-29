/**
 * E45_Medium_Jump_Game_II
 */
public class E45_Medium_Jump_Game_II {
    public int jump(int[] nums) {
        int farthest = 0, current = 0, jump = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (farthest == nums.length - 1)
                return ++jump;
            if (current == i) {
                current = farthest;
                jump++;
            }
        }
        return jump;
    }
}