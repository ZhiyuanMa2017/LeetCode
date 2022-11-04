class Solution {
    public static int atMostNGivenDigitSet(String[] digits, int n) {
        String number = String.valueOf(n);
        int numberlen = number.length();
        int digitlen = digits.length;
        int result = 0;
        for (int i = 1; i < numberlen; i++) {
            result += Math.pow(digitlen, i);
        }

        int[] dp = new int[numberlen + 1];
        dp[numberlen] = 1;

        for (int i = numberlen -1; i >= 0; i--) {
            int ni = number.charAt(i) - '0';
            for (String d : digits) {
                int digit = Integer.parseInt(d);
                if (digit < ni) {
                    dp[i] += Math.pow(digitlen, numberlen - i - 1);
                } else if (digit == ni) {
                    dp[i] += dp[i + 1];
                }
            }
        }
        result += dp[0];
        return result;
    }
}
