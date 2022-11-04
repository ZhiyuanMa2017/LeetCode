public class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        boolean[][][] dp = new boolean[41][41][2000];
        int n = s1.length();
        int m = s2.length();
        dp[0][0][1000] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k < 2000; k++) {
                    if (dp[i][j][k]) {
                        if (i < n && j < m && k == 1000 && s1.charAt(i) == s2.charAt(j)) {
                            dp[i + 1][j + 1][k] = true;
                        }
                        if (k >= 1000 && j < m) {
                            if (Character.isLetter(s2.charAt(j))) {
                                if (k > 1000) {
                                    dp[i][j + 1][k - 1] = true;
                                }
                            } else if (s2.charAt(j) > '0') {
                                int cur = 0;
                                for (int r = j; r < m; r++) {
                                    if (Character.isDigit(s2.charAt(r))) {
                                        cur = cur * 10 + (s2.charAt(r) - '0');
                                        dp[i][r + 1][k - cur] = true;
                                    } else {
                                        break;
                                    }
                                }

                            }
                        }
                        if (k <= 1000 && i < n) {
                            if (Character.isLetter(s1.charAt(i))) {
                                if (k < 1000) {
                                    dp[i + 1][j][k + 1] = true;
                                }
                            } else if (s1.charAt(i) > '0') {
                                int cur = 0;
                                for (int r = i; r < n; r++) {
                                    if (Character.isDigit(s1.charAt(r))) {
                                        cur = cur * 10 + (s1.charAt(r) - '0');
                                        dp[r + 1][j][k + cur] = true;
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return dp[n][m][1000];
    }
}
