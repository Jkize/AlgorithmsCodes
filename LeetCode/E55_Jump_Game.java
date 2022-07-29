import java.util.HashSet;

public class E55_Jump_Game {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Jump Game.
     * Memory Usage: 43 MB, less than 86.89% of Java online submissions for Jump
     * Game
     * 
     */
    public boolean canJumpV(int[] nums) {

        int minRange = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {

            if (nums[i] + i >= minRange) {
                minRange = i;
            }

        }

        return minRange == 0;
    }

    /* Time Limit Exceeded */
    public boolean canJumpV2(int[] nums) {

        HashSet<Integer> pos = new HashSet<>();
        if (nums.length == 0 || nums.length == 1) {
            return true;
        }

        pos.add(nums.length - 1);

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 0; j < nums[i]; j++) {
                if (pos.contains(i + nums[i] - j)) {
                    pos.add(i);
                    break;
                }
            }
        }

        return pos.contains(0);
    }

    /**
     * Not work, StackOverFlow
     * 
     * @param nums
     * @param position
     * @return
     */
    public boolean canJumpCheck(int[] nums, int position) {

        if (position >= nums.length)
            return false;

        if (position == nums.length - 1)
            return true;

        for (int i = 0; i < nums[position]; i++) {
            if (position + i < nums.length && canJumpCheck(nums, position + nums[position + i]))
                return true;
        }

        return false;

    }
}
