public class E91_Medium_Decode_Ways {

    public int numDecodings(String s) {

        int prev = 26;
        int result = 0;
        int first = 1, second = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = s.charAt(i) - '0';

            if (digit == 0)
                result = 0;
            else
                result = first + (digit * 10 + prev <= 26 ? second : 0);

            second = first;
            first = result;
            prev = digit;
        }
        return result;
    }
}
