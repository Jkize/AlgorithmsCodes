public class E7_ReverseInteger {

    /**
     * Runtime: 3 ms, faster than 30.73% of Java online submissions for Reverse
     * Integer.
     * Memory Usage: 41.4 MB, less than 48.13% of Java online submissions for
     * Reverse Integer.
     */
    public static int reverse(int x) {
        try {

            StringBuffer res = new StringBuffer();
            int sign = (x >= 0) ? 1 : -1;
            x = (x < 0) ? -x : x;
            if (x == 0)
                return 0;
            while (x != 0) {
                int n = x % 10;
                res.append(n);
                x = x / 10;
            }
            return sign * Integer.parseInt(res.toString());
        } catch (Exception e) {
            return 0;
        }
    }
    /*
     * int	4 bytes	Stores whole numbers from -2,147,483,648 to 2,147,483,647
     */
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
