import java.util.Arrays;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = original.length;
        int[][] dis = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dis[i], (int) 1e8);
            dis[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int c = cost[i];
            dis[u][v] = Math.min(dis[u][v], c);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dis[i][k] + dis[k][j] < dis[i][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }
        long res = 0;
        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';
            if (dis[s][t] == 1e8) {
                return -1;
            }
            res += dis[s][t];
        }
        return res;
    }
}
