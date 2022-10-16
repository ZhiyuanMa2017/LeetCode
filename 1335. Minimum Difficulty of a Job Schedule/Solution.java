
import java.util.Arrays;

class Solution {
    int[][] memo;

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        memo = new int[n + 1][d + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(memo[i], 10001);
        }
        return dfs(jobDifficulty, 0, d);
    }

    private int dfs(int[] jobDifficulty, int lastCut, int remain) {
        if (memo[lastCut][remain] < 10001) {
            return memo[lastCut][remain];
        }
        if (remain == 1) {
            int res = -1;
            for (int i = lastCut; i < jobDifficulty.length; i++) {
                res = Math.max(res, jobDifficulty[i]);
            }
            memo[lastCut][remain] = res;
            return res;
        }
        int curMax = -1;
        for (int i = lastCut; i < jobDifficulty.length - remain + 1; i++) {
            curMax = Math.max(curMax, jobDifficulty[i]);
            memo[lastCut][remain] = Math.min(memo[lastCut][remain], curMax + dfs(jobDifficulty, i + 1, remain - 1));
        }
        return memo[lastCut][remain];
    }
}
