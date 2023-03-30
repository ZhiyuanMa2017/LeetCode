import java.util.Arrays;

class Solution {
    String ss1;
    String ss2;
    int[][][] memo;


    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        ss1 = s1;
        ss2 = s2;
        int n = s1.length();
        memo = new int[n][n][n + 1];
        return dfs(0, 0, n);
    }

    boolean dfs(int i, int j, int len) {
        if (memo[i][j][len] != 0) {
            return memo[i][j][len] == 1;
        }
        String a = ss1.substring(i, i + len);
        String b = ss2.substring(j, j + len);
        if (a.equals(b)) {
            memo[i][j][len] = 1;
            return true;
        }
        if (!check(a, b)) {
            memo[i][j][len] = -1;
            return false;
        }
        for (int left = 1; left < len; left++) {
            int right = len - left;
            if (dfs(i, j, left) && dfs(i + left, j + left, right)) {
                memo[i][j][len] = 1;
                return true;
            }
            if (dfs(i, j + right, left) && dfs(i + left, j, right)) {
                memo[i][j][len] = 1;
                return true;
            }
        }
        memo[i][j][len] = -1;
        return false;
    }

    private boolean check(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        Arrays.sort(aa);
        Arrays.sort(bb);
        return Arrays.equals(aa, bb);
    }
}
