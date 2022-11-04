import java.util.Arrays;

class Solution2 {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        boolean[] good = new boolean[n];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(good, true);
            if (backtrack(statements, good, 0, 0, i)) {
                return n - i;
            }
        }
        return 0;
    }

    public boolean backtrack(int[][] sts, boolean[] good, int idx, int c, int k) {
        if (c == k) {
            return check(sts, good);
        }
        int n = good.length;
        for (int i = idx; i < n; i++) {
            if (good[i]) {
                good[i] = false;
                if (backtrack(sts, good, i + 1, c + 1, k)) {
                    return true;
                }
                good[i] = true;
            }
        }
        return false;
    }

    public boolean check(int[][] sts, boolean[] good) {
        int n = sts.length;
        for (int i = 0; i < n; i++) {
            if (!good[i]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (sts[i][j] == 2) {
                    continue;
                }
                if ((sts[i][j] == 1) != good[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
