import java.util.ArrayList;
import java.util.List;

class Solution {
    int[][] g;
    List<List<Integer>> res;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtrack(0, path);
        return res;
    }

    private void backtrack(int i, List<Integer> path) {
        if (i == g.length - 1) {
            res.add(new ArrayList<>(path));
        }
        for (int j = 0; j < g[i].length; j++) {
            path.add(g[i][j]);
            backtrack(g[i][j], path);
            path.remove(path.size() - 1);
        }
    }
}
