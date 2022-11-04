class Solution {
    int[] dp = new int[10001];

    public int racecar(int target) {
        if (dp[target] > 0) {
            return dp[target];
        }
        // 2^(n-1) <= target < 2^n - 1
        int n = (int) (Math.log(target) / Math.log(2)) + 1;
        if (1 << n == target + 1) {
            // target == 2^n - 1
            dp[target] = n;
        } else {
            // 2^n - 1 - target: AAAAAR | AAAA
            // AAAAAR: n + 1
            // AAAA: racecar((1 << n) - 1 - target)
            dp[target] = racecar((1 << n) - 1 - target) + n + 1;
            for (int forward = 0; forward < n - 1; forward++) {
                // target - 2^(n-1) + 2^forward AAAA R AAA R | AAA
                // AAAA R:  n - 1 + 1
                // AAA R: forward + 1
                // AAA: racecar(target - (1 << (n - 1)) + (1 << forward))
                dp[target] = Math.min(dp[target], racecar(target - (1 << (n - 1)) + (1 << forward)) + n - 1 + 1 + forward + 1);
            }
        }
        return dp[target];
    }
}
