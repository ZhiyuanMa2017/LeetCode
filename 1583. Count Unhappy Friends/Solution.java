class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] order = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                order[i][preferences[i][j]] = j;
            }
        }
        int[] match = new int[n];
        for (int[] pair : pairs) {
            int p1 = pair[0];
            int p2 = pair[1];
            match[p1] = p2;
            match[p2] = p1;
        }
        int res = 0;
        for (int x = 0; x < n; x++) {
            int y = match[x];
            int maxIndex = order[x][y];
            for (int i = 0; i < maxIndex; i++) {
                int u = preferences[x][i];
                int v = match[u];
                if (order[u][x] < order[u][v]) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
