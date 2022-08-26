class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] graph = new boolean[n][n];
        int[] degree = new int[n];
        for (int[] road : roads) {
            int one = road[0];
            int two = road[1];
            degree[one]++;
            degree[two]++;
            graph[one][two] = true;
            graph[two][one] = true;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = degree[i] + degree[j];
                if (graph[i][j]) {
                    sum--;
                }
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
