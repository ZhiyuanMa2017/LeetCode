import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j, 0});
                    res[i][j] = 0;
                }
            }
        }
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int d = cur[2];
                for (int j = 0; j < 4; j++) {
                    int a = x + dirs[j];
                    int b = y + dirs[j + 1];
                    if (a >= 0 && a < m && b >= 0 && b < n && res[a][b] == -1) {
                        res[a][b] = d + 1;
                        queue.offer(new int[]{a, b, d + 1});
                    }
                }
            }
        }
        return res;
    }
}
