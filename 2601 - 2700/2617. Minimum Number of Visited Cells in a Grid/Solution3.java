import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], (int) 1e6);
        }
        dis[0][0] = 1;
        PriorityQueue<int[]>[] row = new PriorityQueue[m];
        PriorityQueue<int[]>[] col = new PriorityQueue[n];
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        for (int i = 0; i < m; i++) {
            row[i] = new PriorityQueue<>(comparator);
        }
        for (int j = 0; j < n; j++) {
            col[j] = new PriorityQueue<>(comparator);
        }
        // O(mn * (logm + logn))
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                while (!row[i].isEmpty() && row[i].peek()[1] + grid[i][row[i].peek()[1]] < j) {
                    row[i].poll();
                }
                if (!row[i].isEmpty()) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][row[i].peek()[1]] + 1);
                }
                while (!col[j].isEmpty() && col[j].peek()[1] + grid[col[j].peek()[1]][j] < i) {
                    col[j].poll();
                }
                if (!col[j].isEmpty()) {
                    dis[i][j] = Math.min(dis[i][j], dis[col[j].peek()[1]][j] + 1);
                }
                if (dis[i][j] < 1e6) {
                    row[i].offer(new int[]{dis[i][j], j});
                    col[j].offer(new int[]{dis[i][j], i});
                }
            }
        }
        if (dis[m - 1][n - 1] >= 1e6) {
            return -1;
        } else {
            return dis[m - 1][n - 1];
        }
    }
}
