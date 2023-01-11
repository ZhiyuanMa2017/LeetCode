import java.util.ArrayList;
import java.util.List;

class Solution {
    ArrayList<Integer>[] tree;
    int res;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        dfs(0, -1, hasApple);
        return res;
    }

    private boolean dfs(int cur, int parent, List<Boolean> hasApple) {
        boolean apple = hasApple.get(cur);
        for (Integer next : tree[cur]) {
            if (next == parent) {
                continue;
            }
            boolean childApple = dfs(next, cur, hasApple);
            if (childApple) {
                res += 2;
                apple = true;
            }
        }
        return apple;
    }
}
