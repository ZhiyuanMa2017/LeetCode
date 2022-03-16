class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        int[] inDegree = new int[n + 1];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (graph[i][j]) {
                    for (int k = j + 1; k < n + 1; k++) {
                        if (graph[j][k] && graph[i][k]) {
                            res = Math.min(res, inDegree[i] + inDegree[j] + inDegree[k] - 6);
                        }
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
