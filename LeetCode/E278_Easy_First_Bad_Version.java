public class E278_Easy_First_Bad_Version {

    int nStartFalse;

    public static void main(String[] args) {

        int n = 1;
        int f = 1;

        E278_Easy_First_Bad_Version dat = new E278_Easy_First_Bad_Version();
        dat.nStartFalse = f;

        System.out.println("Hello");
        System.out.println(dat.firstBadVersion(n));
    }

    public boolean isBadVersion(int n) {

        if (n >= nStartFalse) {
            return true;
        }
        return false;

    }

    /**
     * 
     * Runtime: 71 ms, faster than 1.24% of Java online submissions for First Bad
     * Version.
     * Memory Usage: 40.6 MB, less than 71.48% of Java online submissions for First
     * Bad Version.
     */
    public int firstBadVersion(int n) {

        int lo = 1;
        int hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isBadVersion(lo)) {
                return lo;
            } else if (!isBadVersion(lo) && isBadVersion(mid)) {
                hi = mid;
                lo++;
            } else {
                lo = mid + 1;
            }

        }

        return -1;

    }

    /**
     * 
     * Runtime: 28 ms, faster than 23.33% of Java online submissions for First Bad
     * Version.
     * Memory Usage: 40.6 MB, less than 65.82% of Java online submissions for First
     * Bad Version.
     */
    public int firstBadVersion2(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid))
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}
