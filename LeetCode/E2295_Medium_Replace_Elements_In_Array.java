import java.util.HashMap;

/**
 * E2295_Medium_Replace_Elements_In_Array
 */
public class E2295_Medium_Replace_Elements_In_Array {

    public int[] arrayChange(int[] nums, int[][] operations) {

        HashMap<Integer, Integer> posNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            posNum.put(nums[i], i);
        }
        for (int i = 0; i < operations.length; i++) {
            int posAct = posNum.remove(operations[i][0]);
            nums[posAct] = operations[i][1];
            posNum.put(operations[i][1], posAct);
        }

        return nums;
    }

}