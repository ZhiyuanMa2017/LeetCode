import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int h = cur[2];
            for (int i = 0; i < 4; i++) {
                int a = x + dirs[i];
                int b = y + dirs[i + 1];
                if (a >= 0 && a < m && b >= 0 && b < n) {
                    if (visited[a][b]) {
                        continue;
                    }
                    if (h > heightMap[a][b]) {
                        res += h - heightMap[a][b];
                    }
                    pq.offer(new int[]{a, b, Math.max(heightMap[a][b], h)});
                    visited[a][b] = true;
                }
            }
        }
        return res;
    }
}
