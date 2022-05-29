import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] remove = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(remove[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        remove[0][0] = 0;
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == m - 1 && cur[1] == n - 1) {
                return remove[m - 1][n - 1];
            }
            for (int j = 0; j < 4; j++) {
                int x = cur[0] + dirs[j];
                int y = cur[1] + dirs[j + 1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int curRemove = cur[2];
                    if (grid[x][y] == 1) {
                        curRemove++;
                    }
                    if (curRemove < remove[x][y]) {
                        pq.offer(new int[]{x, y, curRemove});
                        remove[x][y] = curRemove;
                    }
                }
            }
        }
        return remove[m - 1][n - 1];
    }
}
