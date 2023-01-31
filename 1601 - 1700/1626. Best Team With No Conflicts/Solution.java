import java.util.Arrays;

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] player = new int[n][2];
        for (int i = 0; i < n; i++) {
            player[i] = new int[]{ages[i], scores[i]};
        }
        Arrays.sort(player, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = player[i][1];
            res = Math.max(res, dp[i]);
            for (int j = 0; j < i; j++) {
                if (player[i][1] >= player[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + player[i][1]);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}
