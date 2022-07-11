public class E2259_Easy_Remove_Digit_From {

    /**
     * Runtime: 1 ms, faster than 98.02% of Java online submissions for Remove Digit
     * From Number to Maximize Result.
     * 
     * Memory Usage: 41 MB, less than 92.00% of Java online submissions for Remove
     * Digit From Number to Maximize Result.
     */

    public String removeDigit(String number, char digit) {

        StringBuilder max = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                StringBuilder act = new StringBuilder(number);
                act.delete(i, i + 1);
                if (max.compareTo(act) < 0) {
                    max = act;
                }
            }

        }
        return max.toString();

    }
}
