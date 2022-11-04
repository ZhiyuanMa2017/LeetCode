import java.util.LinkedList;
import java.util.Queue;

class Solution20211028 {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int minutes = 0;
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] index = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = index[0] + dirs[j];
                    int y = index[1] + dirs[j + 1];
                    if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes - 1 : -1;
    }
}