public class E12_Medium_Integer_To_Roman {

    public static void main(String[] args) {
        E12_Medium_Integer_To_Roman ab = new E12_Medium_Integer_To_Roman();

        System.out.println(ab.intToRoman(1000));
    }

    /**
     * So simple, only put
     * 1-9
     * 10-90
     * 100-900
     * 1000-3000
     * 
     * @param num
     * @return
     */
    public static String intToRoman2(int num) {
        String M[] = { "", "M", "MM", "MMM" };
        String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

    /**
     * Runtime: 10 ms, faster than 54.66% of Java online submissions for Integer to
     * Roman.
     * Memory Usage: 45.7 MB, less than 51.24% of Java online submissions for
     * Integer to Roman.
     * Next challenges:
     * 
     * @param num
     * @return
     */
    public String intToRoman(int num) {

        StringBuilder res = new StringBuilder();
        int count = 0;
        while (num != 0) {
            int mod = num % 10;
            num /= 10;

            int cE10 = (int) Math.pow(10, count);

            int nmR = mod * (cE10);
            StringBuilder r = new StringBuilder();

            if (mod == 5 ) {
                r.append(getRoman(nmR));

            } else if (mod == 4) {
                r.append(getRoman(5 * cE10 - nmR)).append(getRoman(nmR + cE10));
            } else if (mod == 9) {
                r.append(getRoman(cE10)).append(getRoman(nmR + cE10));
            } else if (mod > 5) {
                r.append(getRoman(5 * cE10));
                for (int i = 6; i <= mod; i++) {
                    r.append(getRoman(cE10));
                }
            } else {
                for (int i = 1; i <= mod; i++) {
                    r.append(getRoman(cE10));
                }
            }
            res.insert(0, r);
            count++;
        }

        return res.toString();
    }

    public String getRoman(int num) {

        switch (num) {
            case 1:
                return "I";
            case 5:
                return "V";
            case 10:
                return "X";
            case 50:
                return "L";
            case 100:
                return "C";
            case 500:
                return "D";
            case 1000:
                return "M";
        }
        return "";

    }
}
