import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        int mMax = 0;
        if (k > 0) {
            List<Integer>[] mGraph = buildGraph(edges2);
            for (int i = 0; i < m; i++) {
                mMax = Math.max(mMax, dfs(mGraph, i, -1, k - 1));
            }
        }
        int[] res = new int[n];
        List<Integer>[] nGraph = buildGraph(edges1);
        for (int i = 0; i < n; i++) {
            res[i] = dfs(nGraph, i, -1, k) + mMax;
        }
        return res;
    }

    private List<Integer>[] buildGraph(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }

    private int dfs(List<Integer>[] graph, int cur, int parent, int k) {
        if (k < 0) {
            return 0;
        }
        int res = 1;
        for (Integer next : graph[cur]) {
            if (next == parent) {
                continue;
            }
            res += dfs(graph, next, cur, k - 1);
        }
        return res;
    }
}
