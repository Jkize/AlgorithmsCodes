import java.util.HashMap;

public class E42_Easy_Valid_Anagram {

    public boolean isAnagram(String s, String p) {
        if (s.length() != p.length()) {
            return false;
        }

        
        HashMap<Character, Integer> pCount = new HashMap<>();
        HashMap<Character, Integer> sCount = new HashMap<>();
        
        for (int i = 0; i < p.length(); i++) {
            pCount.put(p.charAt(i), (pCount.get(p.charAt(i)) != null) ? pCount.get(p.charAt(i)) + 1 : 1);
            sCount.put(s.charAt(i), (sCount.get(s.charAt(i)) != null) ? sCount.get(s.charAt(i)) + 1 : 1);
        }

        return pCount.equals(sCount);
    }

    /**
     * This is so much faster than mine
     */
    public boolean isAnagramv2(String s, String t)
    {
        if(s.length() != t.length())
            return false;
        
        int fs[] = new int[26];
        int ft[] = new int[26];
        
        for(int i=0; i<s.length(); ++i)
        {
            fs[s.charAt(i)-97]++;
            ft[t.charAt(i)-97]++;
        }
        
        for(int i=0; i<26; ++i)
        {
            if(ft[i] != fs[i])
                return false;
        }
        return true;
    }
}
