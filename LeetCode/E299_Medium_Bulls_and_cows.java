public class E299_Medium_Bulls_and_cows {
    public static void main(String[] args) {
        String a = "092";
        System.out.println(48 - a.charAt(0) + " " + (int) a.charAt(2));
    }

    /**
     * Runtime: 10 ms, faster than 55.10% of Java online submissions for Bulls and
     * Cows.
     * Memory Usage: 43.2 MB, less than 31.87% of Java online submissions for Bulls
     * and Cows.
     */
    public String getHint(String secret, String guess) {
        int[] dictSecrect = new int[10];
        int[] dictGuess = new int[10];
        int cows = 0, bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            int cS = secret.charAt(i) - 48;
            int cG = guess.charAt(i) - 48;
            if (cS == cG) {
                bulls++;
            } else {
                if (dictGuess[cS] > 0) {
                    cows++;
                    dictGuess[cS]--;
                } else {
                    dictSecrect[cS]++;
                }

                if (dictSecrect[cG] > 0) {
                    cows++;
                    dictSecrect[cG]--;
                } else {
                    dictGuess[cG]++;
                }
            }
        }

        return bulls + "A" + cows + "B";
    }

    /**
     * Better solution
     * @param secret
     * @param guess
     * @return
     */
    public String getHintV2(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i))
                bulls++;
            else {
                if (numbers[secret.charAt(i) - '0']++ < 0)
                    cows++;
                if (numbers[guess.charAt(i) - '0']-- > 0)
                    cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
