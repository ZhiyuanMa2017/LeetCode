import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> graph;
    boolean[] visited;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        visited = new boolean[n];
        graph = new ArrayList<>();
        for (int i : restricted) {
            visited[i] = true;
        }
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return dfs(0);
    }

    private int dfs(int i) {
        if (visited[i]) {
            return 0;
        }
        int res = 1;
        visited[i] = true;
        for (Integer next : graph.get(i)) {
            if (!visited[next]) {
                res += dfs(next);
            }
        }
        return res;
    }
}
