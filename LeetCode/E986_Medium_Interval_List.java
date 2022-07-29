import java.util.ArrayList;
import java.util.List;

/**
 * E986_Interval_List
 */
public class E986_Medium_Interval_List {

    public static void main(String[] args) {
        E986_Medium_Interval_List sol = new E986_Medium_Interval_List();
    }

    /**
     * Runtime: 4 ms, faster than 78.72% of Java online submissions for Interval
     * List Intersections.
     * Memory Usage: 54.8 MB, less than 36.26% of Java online submissions for
     * Interval List Intersections.
     * 
     * @param firstList
     * @param secondList
     * @return
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();

        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {

            int[] l;
            int[] s;

            if (firstList[i][1] > secondList[j][1]) {
                l = firstList[i];
                s = secondList[j];
                j++;
            } else {
                l = secondList[j];
                s = firstList[i];
                i++;
            }

            if (s[0] >= l[0] && s[1] <= l[1]) {
                list.add(s);
            } else if (l[0] >= s[0] && l[0] <= s[1]) {
                int[] r = { l[0], l[0] };
                if (s[1] <= l[1]) {
                    r[1] = s[1];
                }
                list.add(r);
            }

        }

        return toIntArray(list);
    }

    public int[][] toIntArray(List<int[]> list) {
        int[][] ret = new int[list.size()][2];
        int i = 0;
        for (int[] e : list)
            ret[i++] = e;
        return ret;
    }



    public int[][] intervalIntersectionV2(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
    
        while (i < A.length && j < B.length) {
          // Let's check if A[i] intersects B[j].
          // lo - the startpoint of the intersection
          // hi - the endpoint of the intersection
          int lo = Math.max(A[i][0], B[j][0]);
          int hi = Math.min(A[i][1], B[j][1]);
          if (lo <= hi)
            ans.add(new int[]{lo, hi});
    
          // Remove the interval with the smallest endpoint
          if (A[i][1] < B[j][1])
            i++;
          else
            j++;
        }
    
        return ans.toArray(new int[ans.size()][]);
      }
}