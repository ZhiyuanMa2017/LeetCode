import java.util.Arrays;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], (int) 1e6);
            dis[i][i] = 0;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dis[u][v] = w;
            dis[v][u] = w;
        }
        // Floyd-Warshall
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dis[j][i] + dis[i][k] < dis[j][k]) {
                        dis[j][k] = dis[j][i] + dis[i][k];
                    }
                }
            }
        }
        int res = 0;
        int count = n;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (dis[i][j] <= distanceThreshold) {
                    cur++;
                }
            }
            if (cur <= count) {
                count = cur;
                res = i;
            }
        }
        return res;
    }
}
