import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                // 当 [i, j] 只有一个字符时，必然是回文串
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    // 当 [i, j] 长度为 2 时，满足 cs[i] == cs[j] 即回文串
                    if (j - i + 1 == 2) {
                        dp[i][j] = s.charAt(i) == s.charAt(j);

                        // 当 [i, j] 长度大于 2 时，满足 (cs[i] == cs[j] && f[i + 1][j - 1]) 即回文串
                    } else {
                        dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                    }
                }
            }
        }
        backtrack(res, new ArrayList<>(), dp, 0, s);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> path, boolean[][] dp, int start, String s) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                path.add(s.substring(start, i + 1));
                backtrack(res, path, dp, i + 1, s);
                path.remove(path.size() - 1);
            }
        }
    }
}
