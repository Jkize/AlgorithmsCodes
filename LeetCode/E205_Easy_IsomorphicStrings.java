import java.util.ArrayList;
import java.util.HashMap;

/**
 * E205_Easy_IsomorphicStrings
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class E205_Easy_IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, ArrayList<Integer>> map1 = new HashMap<>();
        HashMap<Character, ArrayList<Integer>> map2 = new HashMap<>();

        ArrayList<Character> a1 = new ArrayList<>();
        ArrayList<Character> a2 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            add(s.charAt(i), i, map1, a1);
            add(t.charAt(i), i, map2, a2);
        }
        if (a1.size() != a2.size()) {
            return false;
        }

        for (int i = 0; i < a1.size(); i++) {
            if (!map1.get(a1.get(i)).equals(map2.get(a2.get(i)))) {
                return false;
            }
        }

        return true;
    }

    public void add(Character c, int pos, HashMap<Character, ArrayList<Integer>> map, ArrayList<Character> aC) {
        if (map.containsKey(c)) {
            map.get(c).add(pos);
        } else {
            map.put(c, new ArrayList<>());
            map.get(c).add(pos);
            aC.add(c);
        }
    }

    /**
     * 
     * 
     * Runtime: 7 ms, faster than 81.87% of Java online submissions for Isomorphic
     * Strings.
     * 
     * Memory Usage: 41.8 MB, less than 98.11% of Java online submissions for
     * Isomorphic Strings.
     */
    public boolean isIsomorphic2(String s, String t) {
        HashMap<Character, Character> mapT = new HashMap<>();
        HashMap<Character, Character> mapS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character s1 = s.charAt(i);
            Character t1 = t.charAt(i);

            if (!mapT.containsKey(s1) && !mapS.containsKey(t1)) {
                mapT.put(s1, t1);
                mapS.put(t1, s1);
            } else {
                if (s1 != mapS.get(t1) || t1 != mapT.get(s1)) {
                    return false;
                }
            }

        }

        return true;
    }
}