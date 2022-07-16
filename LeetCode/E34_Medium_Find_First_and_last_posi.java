import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * #priorityqueue #queue #priority
 */

public class E34_Medium_Find_First_and_last_posi {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        List<String> res = new ArrayList<>();

        List<Count> count = new ArrayList<>();
        for (String st : words) {
            if (map.containsKey(st)) {
                count.get(map.get(st)).value++;
            } else {
                map.put(st, count.size());
                count.add(new Count(st));
            }
        }

        count.sort((a, b) -> {
            if (b.value - a.value != 0) {
                return b.value - a.value;
            }

            return a.str.compareTo(b.str);
        });

        for (int i = 0; i < k; i++) {
            res.add(count.get(i).str);
        }

        return res;
    }

    static class Count {
        String str;
        int value;

        Count(String str) {
            this.str = str;
            this.value = 1;
        }
    }
}
