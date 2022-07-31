class Solution {
    int[] visited;
    int[] dis;
    int[] EDGES;

    public int longestCycle(int[] edges) {
        EDGES = edges;
        int n = edges.length;
        visited = new int[n];
        dis = new int[n];
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                res = Math.max(res, dfs(i, 0));
            }
        }
        return res;
    }

    private int dfs(int i, int curDis) {
        visited[i] = 1;
        dis[i] = curDis;
        int res = -1;
        int next = edges[i];
        if (next != -1) {
            if (visited[next] == 0) {
                res = Math.max(res, dfs(next, curDis + 1));
            } else if (visited[next] == 1) {
                return dis[i] - dis[next] + 1;
            }
        }
        visited[i] = 2;
        return res;
    }
}
