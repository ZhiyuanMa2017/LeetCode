import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int step = 0;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    int x = cur[0] + dirs[j];
                    int y = cur[1] + dirs[j + 1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }

                    int countK = cur[2] + grid[x][y];
                    if (countK > k) {
                        continue;
                    }
                    if (countK >= visited[x][y]) {
                        continue;
                    }
                    visited[x][y] = countK;
                    q.offer(new int[]{x, y, countK});

                }
            }
            step++;
        }
        return -1;
    }
}
