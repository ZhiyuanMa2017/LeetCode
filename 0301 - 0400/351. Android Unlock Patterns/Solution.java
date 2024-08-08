import java.util.Arrays;

class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] jump = new int[10][10];
        jump[1][3] = 2;
        jump[3][1] = 2;
        jump[4][6] = 5;
        jump[6][4] = 5;
        jump[7][9] = 8;
        jump[9][7] = 8;
        jump[1][7] = 4;
        jump[7][1] = 4;
        jump[2][8] = 5;
        jump[8][2] = 5;
        jump[3][9] = 6;
        jump[9][3] = 6;
        jump[1][9] = 5;
        jump[9][1] = 5;
        jump[3][7] = 5;
        jump[7][3] = 5;
        int[][] dp = new int[10][1 << 11];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = backtrack(1, 1, 0, jump, m, n, dp) * 4;
        res += backtrack(2, 1, 0, jump, m, n, dp) * 4;
        return res + backtrack(5, 1, 0, jump, m, n, dp);
    }

    private int backtrack(int cur, int len, int bit, int[][] jump, int m, int n, int[][] dp) {
        if (len > n) {
            return 0;
        }
        if (dp[cur][bit] != -1) {
            return dp[cur][bit];
        }
        bit |= 1 << cur;
        int res = 0;
        if (len >= m) {
            res++;
        }
        for (int next = 1; next <= 9; next++) {
            int jumpNumber = jump[cur][next];
            if (((bit >> next) & 1) == 1) {
                continue;
            }
            if (jumpNumber == 0 || ((bit >> jumpNumber) & 1) == 1) {
                res += backtrack(next, len + 1, bit, jump, m, n, dp);
            }
        }
        bit ^= 1 << cur;
        dp[cur][bit] = res;
        return res;
    }
}
