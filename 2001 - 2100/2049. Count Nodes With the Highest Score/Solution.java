import java.util.ArrayList;
import java.util.List;

class Solution {
    long score;
    int res;
    List<List<Integer>> tree;
    int n;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            tree.get(parents[i]).add(i);
        }
        score = 0;
        res = 0;
        dfs(0);
        return res;
    }

    private int dfs(int node) {
        int total = 0;
        long product = 1;
        long remain = 0;
        long val = 0;
        for (int i : tree.get(node)) {
            val = dfs(i);
            total += val;
            product *= val;
        }
        remain = n - total - 1;
        if (remain > 0) {
            product *= remain;
        }
        if (product > score) {
            score = product;
            res = 1;
        } else if (product == score) {
            res++;
        }
        return total + 1;
    }
}
