class Solution {
    public int squareFreeSubsets(int[] nums) {
        int n = nums.length;
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int mod = (int) (1e9 + 7);
        long[] dp = new long[1 << 10];
        for (int num : nums) {
            if (num % 4 == 0 || num % 9 == 0 || num % 25 == 0) {
                continue;
            }
            int mask = 0;
            for (int i = 0; i < primes.length; i++) {
                if (num % primes[i] == 0) {
                    mask |= 1 << i;
                }
            }
            long[] tmp = new long[1 << 10];
            for (int i = 0; i < 1 << 10; i++) {
                if (dp[i] == 0) {
                    continue;
                }
                if ((mask & i) == 0) {
                    tmp[mask | i] = dp[i];
                }
            }
            for (int i = 0; i < 1 << 10; i++) {
                dp[i] = (dp[i] + tmp[i]) % mod;
            }
            dp[mask] = (dp[mask] + 1) % mod;
        }
        long res = 0;
        for (int i = 0; i < 1 << 10; i++) {
            res = (res + dp[i]) % mod;
        }
        return (int) res;
    }
}
