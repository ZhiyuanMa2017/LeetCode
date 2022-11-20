class Solution {
    public int beautifulPartitions(String s, int k, int minLength) {
        int mod = 1000000007;
        int[][] dp = new int[k + 1][s.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i < k + 1; i++) {
            int count = 0;
            for (int j = minLength - 1; j < s.length(); j++) {
                if ((j == minLength - 1 || !isPrime(s.charAt(j - minLength)))
                        && isPrime(s.charAt(j - minLength + 1))) {
                    count = (count + dp[i - 1][j - minLength + 1]) % mod;
                }
                if (!isPrime(s.charAt(j))) {
                    dp[i][j + 1] = count;
                }
            }
        }
        return dp[k][s.length()];
    }

    private boolean isPrime(char c) {
        return c == '2' || c == '3' || c == '5' || c == '7';
    }
}
