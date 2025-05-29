import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<Integer>[] mGraph = buildGraph(edges2);
        int[] count = dfs2(mGraph, 0, -1);
        int max2 = Math.max(count[0], count[1]);
        List<Integer>[] nGraph = buildGraph(edges1);
        Set<Integer> group = new HashSet<>();
        dfs1(nGraph, 0, -1, group, 0);
        int[] res = new int[n];
        int inGroup = max2 + group.size();
        int notInGroup = max2 + n - group.size();
        for (int i = 0; i < n; i++) {
            if (group.contains(i)) {
                res[i] = inGroup;
            } else {
                res[i] = notInGroup;
            }
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

    private int[] dfs2(List<Integer>[] graph, int cur, int parent) {
        int[] res = new int[]{1, 0};
        for (Integer next : graph[cur]) {
            if (next == parent) {
                continue;
            }
            int[] sub = dfs2(graph, next, cur);
            res[0] += sub[1];
            res[1] += sub[0];
        }
        return res;
    }

    private void dfs1(List<Integer>[] graph, int cur, int parent, Set<Integer> group, int step) {
        if (step % 2 == 0) {
            group.add(cur);
        }
        for (Integer next : graph[cur]) {
            if (next == parent) {
                continue;
            }
            dfs1(graph, next, cur, group, step + 1);
        }
    }
}
