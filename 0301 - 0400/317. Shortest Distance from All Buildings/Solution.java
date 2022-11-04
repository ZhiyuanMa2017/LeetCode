import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] distance;
    int[][] buildingsCanReach;
    int[] dirs;

    public int shortestDistance(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        distance = new int[m][n];
        buildingsCanReach = new int[m][n];
        dirs = new int[]{-1, 0, 1, 0, -1};
        int totalBuildings = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    bfs(grid, i, j, totalBuildings);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && buildingsCanReach[i][j] == totalBuildings) {
                    res = Math.min(res, distance[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void bfs(int[][] grid, int i, int j, int totalBuildings) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int p = 0; p < size; p++) {
                int[] cur = queue.poll();
                for (int q = 0; q < 4; q++) {
                    int x = cur[0] + dirs[q];
                    int y = cur[1] + dirs[q + 1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                        if (grid[x][y] == 0 && !visited[x][y]) {
                            visited[x][y] = true;
                            buildingsCanReach[x][y]++;
                            distance[x][y] += step;
                            if (buildingsCanReach[x][y] == totalBuildings) {
                                queue.offer(new int[]{x, y});
                            }
                        }
                    }
                }
            }
            step++;
        }
    }
}
