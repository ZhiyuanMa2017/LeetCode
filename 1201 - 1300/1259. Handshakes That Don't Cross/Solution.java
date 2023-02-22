class Solution {
    public int numberOfWays(int numPeople) {
        int mod = (int) (1e9 + 7);
        long[] dp = new long[numPeople + 1];
        dp[0] = 1;
        dp[2] = 1;
        for (int i = 4; i <= numPeople; i += 2) {
            int pivot = 1;
            for (int next = 2; next <= i; next += 2) {
                int first = next - pivot - 1;
                int second = i - next;
                dp[i] = (dp[i] + dp[first] * dp[second] % mod) % mod;
            }
        }
        return (int) dp[numPeople];
    }
}
