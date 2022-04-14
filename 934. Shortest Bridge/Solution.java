import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dirs = new int[]{-1, 0, 1, 0, -1};

    public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid.length];
        makeOneToTwo(grid, q, visited);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int p = 0; p < 4; p++) {
                    int x = cur[0] + dirs[p];
                    int y = cur[1] + dirs[p + 1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid.length && !visited[x][y]) {
                        if (grid[x][y] == 1) {
                            return step;
                        }
                        q.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            step++;
        }
        return step;
    }


    private void makeOneToTwo(int[][] grid, Queue<int[]> q, boolean[][] visited) {
        int n = grid.length;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (found) {
                return;
            }
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, q, visited);
                    found = true;
                    break;
                }
            }
        }
    }

    private void dfs(int[][] grid, int i, int j, Queue<int[]> q, boolean[][] visited) {
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        for (int p = 0; p < 4; p++) {
            int x = i + dirs[p];
            int y = j + dirs[p + 1];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid.length && !visited[x][y] && grid[x][y] == 1) {
                dfs(grid, x, y, q, visited);
            }
        }
    }
}
