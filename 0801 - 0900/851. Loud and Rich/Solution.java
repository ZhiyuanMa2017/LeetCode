import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] rich : richer) {
            int more = rich[0];
            int less = rich[1];
            graph.get(less).add(more);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            dfs(i, res, graph, quiet);
        }
        return res;
    }

    private int dfs(int i, int[] res, List<List<Integer>> graph, int[] quiet) {
        if (res[i] > 0) {
            return res[i];
        }
        res[i] = i;
        for (int j : graph.get(i)) {
            int next = dfs(j, res, graph, quiet);
            if (quiet[next] < quiet[res[i]]) {
                res[i] = next;
            }
        }
        return res[i];
    }
}
