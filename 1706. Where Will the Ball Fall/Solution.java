import java.util.Arrays;

class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        if (n == 1) {
            return res;
        }
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            cur[i] = i;
        }
        int[] tmp;
        for (int i = 0; i < m; i++) {
            tmp = new int[n];
            Arrays.fill(tmp, -1);
            for (int j = 0; j < n; j++) {
                if (cur[j] >= 0) {
                    if (grid[i][j] == 1) {
                        if (j < n - 1 && grid[i][j + 1] == 1) {
                            tmp[j + 1] = cur[j];
                        }
                    } else if (grid[i][j] == -1) {
                        if (j > 0 && grid[i][j - 1] == -1) {
                            tmp[j - 1] = cur[j];
                        }
                    }
                }
            }
            cur = tmp;
        }
        for (int i = 0; i < n; i++) {
            if (cur[i] >= 0) {
                res[cur[i]] = i;
            }
        }
        return res;
    }
}
