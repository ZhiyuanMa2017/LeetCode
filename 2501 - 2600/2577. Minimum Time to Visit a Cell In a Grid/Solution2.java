import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dis = new int[m][n];
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curDis = cur[0];
            int i = cur[1];
            int j = cur[2];
            if (i == m - 1 && j == n - 1) {
                return curDis;
            }
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (curDis + 1 >= grid[x][y]) {
                        int nextDis = curDis + 1;
                        if (nextDis < dis[x][y]) {
                            dis[x][y] = nextDis;
                            pq.offer(new int[]{nextDis, x, y});
                        }
                    } else if (!(x == 0 && y == 0)) {
                        int tmp = curDis + 1;
                        int diff = grid[x][y] - tmp;
                        if (diff % 2 == 1) {
                            diff++;
                        }
                        int nextDis = tmp + diff;
                        if (nextDis < dis[x][y]) {
                            dis[x][y] = nextDis;
                            pq.offer(new int[]{nextDis, x, y});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
