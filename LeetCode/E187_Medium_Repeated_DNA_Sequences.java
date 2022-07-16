import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class E187_Medium_Repeated_DNA_Sequences {

    public static void main(String[] args) {
        E187_Medium_Repeated_DNA_Sequences ab = new E187_Medium_Repeated_DNA_Sequences();
        ab.findRepeatedDnaSequences(
                "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> arr = new ArrayList<>();
        HashMap<String, Integer> hash = new HashMap<>();

        for (int l = 0, r = 10; r <= s.length(); l++, r++) {
            String subA = s.substring(l, r);
            hash.merge(subA, 1, Integer::sum);
            if (hash.get(subA) == 2) {
                arr.add(subA);
            }
        }
        return arr;
    }
}
