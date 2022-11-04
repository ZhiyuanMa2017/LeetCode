import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshNum = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshNum++;
                }
            }
        }
        if (freshNum == 0) {
            return 0;
        }
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        int round = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = rotten[0] + dirs[j];
                    int y = rotten[1] + dirs[j + 1];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.add(new int[]{x, y});
                        freshNum--;
                    }
                }
            }
            round++;
        }
        return freshNum == 0 ? round - 1 : -1;
    }
}
