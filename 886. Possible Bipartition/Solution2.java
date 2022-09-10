import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (count[i] != 0) {
                continue;
            }
            count[i] = 1;
            if (!dfs(graph, i, count, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int cur, int[] count, int color) {
        count[cur] = color;
        for (Integer integer : graph.get(cur)) {
            if (count[integer] == color) {
                return false;
            }
            if (count[integer] == 0 && !dfs(graph, integer, count, -color)) {
                return false;
            }
        }
        return true;
    }
}
