import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> c : connections) {
            graph[c.get(0)].add(c.get(1));
            graph[c.get(1)].add(c.get(0));
        }
        Set<List<Integer>> edges = new HashSet<>(connections);
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        dfs(graph, 0, 0, rank, edges);
        return new ArrayList<>(edges);
    }

    private int dfs(
            List<Integer>[] graph, int thisNode, int depth, int[] rank, Set<List<Integer>> edges) {
        if (rank[thisNode] >= 0) {
            return rank[thisNode];
        }
        rank[thisNode] = depth;
        int nowMinDepth = depth;
        for (Integer neighbour : graph[thisNode]) {
            if (rank[neighbour] == depth - 1) {
                continue;
            }
            int returnDepth = dfs(graph, neighbour, depth + 1, rank, edges);
            if (returnDepth <= depth) {
                edges.remove(Arrays.asList(thisNode, neighbour));
                edges.remove(Arrays.asList(neighbour, thisNode));
            }
            nowMinDepth = Math.min(nowMinDepth, returnDepth);
        }
        return nowMinDepth;
    }
}
