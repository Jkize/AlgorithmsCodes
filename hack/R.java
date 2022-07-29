import java.util.ArrayList;
import java.util.List;

/**
 * R
 */
public class R {

    public static void main(String[] args) {
        List<String> ab = new ArrayList<>();
        ab.add("abcdde");
        ab.add("baccd");
        ab.add("eeabg");
        int r = gemstones(ab);
    }

    public static int gemstones(List<String> rocks) {

        if (rocks.size() == 1) {
            return rocks.size();
        }
        // Without using hashSet. More faster
        int[][] hash = new int[rocks.size()][26];

        for (int i = 0; i < rocks.size(); i++) {
            for (char c : rocks.get(i).toCharArray()) {
                hash[i][c] = 1;
            }
        }

        int count = 0;

        for (int c = 0; c < hash[0].length; c++) {

            if (hash[0][c] == 0)
                continue;

            boolean repeated = true;

            for (int i = 1; i < hash.length; i++) {
                if (hash[i][c] == 0) {
                    repeated = false;
                    break;
                }
            }
            if (repeated)
                count++;

        }

        return count;

    }
}