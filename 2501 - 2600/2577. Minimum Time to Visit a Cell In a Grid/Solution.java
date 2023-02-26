import java.util.PriorityQueue;

class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        boolean[][] visited = new boolean[m][n];
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        visited[0][0] = true;
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
                    if (visited[x][y]) {
                        continue;
                    }
                    int dd = curDis + 1;
                    visited[x][y] = true;
                    int diff = grid[x][y] - dd;
                    if (diff <= 0) {
                        pq.offer(new int[]{dd, x, y});
                    } else {
                        if (diff % 2 == 1) {
                            diff++;
                        }
                        pq.offer(new int[]{dd + diff, x, y});
                    }
                }
            }
        }
        return -1;
    }
}
