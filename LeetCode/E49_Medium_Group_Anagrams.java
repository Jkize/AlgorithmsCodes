import java.util.*;

public class E49_Medium_Group_Anagrams {

    /**
     * Runtime: 12 ms, faster than 70.34% of Java online submissions for Group
     * Anagrams.
     * Memory Usage: 55.4 MB, less than 73.46% of Java online submissions for Group
     * Anagrams.
     * 
     * 
     * Time Complexity: m*nlog(n) [m -> how many word there are]
     * 
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lt = new ArrayList<>();
        HashMap<String, Integer> posAnagram = new HashMap<>();

        for (String st : strs) {
            char[] c = st.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if (posAnagram.containsKey(key)) {
                lt.get(posAnagram.get(key)).add(st);
            } else {
                posAnagram.put(key, lt.size());
                lt.add(new ArrayList<>());
                lt.get(lt.size() - 1).add(st);
            }
        }

        return lt;
    }

    /**
     * Runtime: 11 ms, faster than 79.00% of Java online submissions for Group
     * Anagrams.
     * Memory Usage: 56.2 MB, less than 44.46% of Java online submissions for Group
     * Anagrams.
     * 
     * 
     * Time Complexity: m*n [m -> how many word there are]
     * 
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsV2(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        if (strs == null) {
            return answer;
        }

        for (String word : strs) {
            char[] letters = new char[26];
            for (int i = 0; i < word.length(); i++) {
                letters[word.charAt(i) - 'a']++;
            }
            String sorted = new String(letters);

            if (!map.containsKey(sorted)) {
                map.put(sorted, answer.size());
                answer.add(new ArrayList<>());
            }
            answer.get(map.get(sorted)).add(word);

        }
        return answer;
    }

}
