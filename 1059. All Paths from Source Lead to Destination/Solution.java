import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        boolean[] seen = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
        }
        if (graph.get(destination).size() > 0) {
            return false;
        }
        return dfs(graph, source, destination, seen);
    }

    private boolean dfs(List<List<Integer>> graph, int source, int des, boolean[] seen) {
        if (source == des) {
            return true;
        }
        if (graph.get(source).size() == 0) {
            return false;
        }
        seen[source] = true;
        for (Integer next : graph.get(source)) {
            if (seen[next]) {
                return false;
            }
            if (!dfs(graph, next, des, seen)) {
                return false;
            }
        }
        seen[source] = false;
        return true;
    }
}
