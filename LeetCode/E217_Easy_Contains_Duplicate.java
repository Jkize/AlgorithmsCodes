import java.util.HashSet;

public class E217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> v = new HashSet<>();
        for (int n : nums) {
            if (!v.add(n))
                return true;
        }
        return false;
    }
}
