import java.util.HashSet;
import java.util.Set;

/**
 * E128_Longest_Consecutive_Sequence
 */
public class E128_Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        int r = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        for (int n : nums) {

            if (!set.contains(n - 1)) {
                int cont = 1;
                while (set.contains(++n)) {
                    cont++;
                }
                if (cont > r)
                    r = cont;
            }

        }

        return r;
    }

    public int longestConsecutiveV2(int[] nums) {
        Set<Integer> max = new HashSet<>();
        for (int num : nums) {
            max.add(num);
        }
        int maxLen = 0;
        for (int num : nums) {
            if (maxLen > max.size()) {
                break;
            }
            if (max.contains(num)) {
                int len = 0;
                max.remove(num);
                len++;
                int left = num - 1;
                while (max.contains(left)) {
                    len++;
                    max.remove(left);
                    left = left - 1;
                }
                int right = num + 1;
                while (max.contains(right)) {
                    len++;
                    max.remove(right);
                    right = right + 1;
                }
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }

    public int longestConsecutiveV3(int[] nums) {
        final HashSet<Integer> mySet = new HashSet();
        for (int i : nums)
            mySet.add(i);

        int longest = 0;
        for (int i : nums) {
            int length = 1;

            if (longest > mySet.size()) {
                break;
            }

            for (int j = i - 1; mySet.contains(j); --j) {
                mySet.remove(j);
                ++length;
            }
            for (int j = i + 1; mySet.contains(j); ++j) {
                mySet.remove(j);
                ++length;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }

}