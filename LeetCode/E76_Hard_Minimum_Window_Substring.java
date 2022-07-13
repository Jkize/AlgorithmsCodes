
public class E76_Hard_Minimum_Window_Substring {

    public static void main(String[] args) {
        E76_Hard_Minimum_Window_Substring sol = new E76_Hard_Minimum_Window_Substring();
        String xd = sol.minWindow("a", "aa");
        System.out.println(xd);
    }

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        int minL = 0, minR = 0, l = 0, r = 0;
        int mapS[] = new int[128];
        int mapT[] = new int[128];
        int minLength = Integer.MAX_VALUE;
        for (char c : t.toCharArray()) {
            mapT[c]++;
        }

        while (r < s.length()) {
            if (!compareE(mapS, mapT)) {
                mapS[s.charAt(r++)]++;
            }
            while (compareE(mapS, mapT)) {
                if (minLength > r - l) {
                    minR = r;
                    minL = l;
                    minLength = r - l;
                }
                mapS[s.charAt(l++)]--;
            }
        }

        if (minR != 0) {
            return s.substring(minL, minR);
        } else {
            return "";
        }

    }

    public boolean compareE(int[] mapS, int[] mapT) {

        for (int i = 0; i < mapT.length; i++) {
            if (mapS[i] < mapT[i])
                return false;
        }

        return true;
    }

    /**
     * Better Solution
     * 
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] > 0)
                counter--;
            map[c1]--;
            end++;
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                final char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0)
                    counter++;
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

}
