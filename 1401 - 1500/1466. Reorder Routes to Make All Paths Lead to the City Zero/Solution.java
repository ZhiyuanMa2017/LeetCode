import java.util.ArrayList;
import java.util.List;

class Solution {
    List<int[]>[] graph;
    int res;

    public int minReorder(int n, int[][] connections) {
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            // edge, dest
            graph[from].add(new int[]{to, to});
            graph[to].add(new int[]{from, to});
        }
        res = 0;
        dfs(0, -1);
        return res;
    }

    private void dfs(int cur, int parent) {
        for (int[] ints : graph[cur]) {
            int next = ints[0];
            int dest = ints[1];
            if (next == parent) {
                continue;
            }
            if (next == dest) {
                res++;
            }
            dfs(next, cur);
        }
    }
}
