import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int dis = 1;
        // brute force BFS from large to small
        // passed but should get TLE
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if (x == m - 1 && y == n - 1) {
                    return dis;
                }
                for (int nx = Math.min(m - 1, grid[x][y] + x); nx >= x + 1; nx--) {
                    if (!visited[nx][y]) {
                        queue.offer(new int[]{nx, y});
                        visited[nx][y] = true;
                    }
                }
                for (int ny = Math.min(n - 1, y + grid[x][y]); ny >= y + 1; ny--) {
                    if (!visited[x][ny]) {
                        queue.offer(new int[]{x, ny});
                        visited[x][ny] = true;
                    }
                }
            }
            dis++;
        }
        return -1;
    }
}
