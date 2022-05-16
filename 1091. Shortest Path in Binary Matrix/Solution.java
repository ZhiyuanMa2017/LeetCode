import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int step = 1;
        int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 0}, {1, -1}, {1, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if (x == n - 1 && y == n - 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int x1 = x + dir[0];
                    int y1 = y + dir[1];
                    if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < n && !visited[x1][y1] && grid[x1][y1] == 0) {
                        queue.offer(new int[]{x1, y1});
                        visited[x1][y1] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
