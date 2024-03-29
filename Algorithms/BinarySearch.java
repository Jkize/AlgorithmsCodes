public class BinarySearch {

    /**
     * Use binary search.
     * 
     * n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
     * 
     * an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
     * 
     * @param matriz
     * @param target
     * @return
     */
    public boolean find2d(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l != r) {
            int mid = (l + r - 1) >> 1;
            if (matrix[mid / m][mid % m] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return matrix[r / m][r % m] == target;
    }

    public int binarySearch2d(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target < matrix[mid][0])
                r = mid - 1;
            else if (target > matrix[mid][matrix[mid].length - 1])
                l = mid + 1;
            else
                return binarySearch(matrix[mid], target);
        }

        return -1;
    }

    public int binarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    private int findFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }

    public int recursive(int key, int[] a, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
            return recursive(key, a, lo, mid - 1);
        else if (key > a[mid])
            return recursive(key, a, mid + 1, hi);
        else
            return mid;
    }
}
