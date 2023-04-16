import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer>[] tree;
    int[] count;
    int[][] dp;
    int[] p;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        count = new int[n];
        for (int[] trip : trips) {
            int from = trip[0];
            int to = trip[1];
            dfs(from, -1, to);
        }
        for (int i = 0; i < n; i++) {
            price[i] *= count[i];
        }
        p = price;
        int[] res = dfs2(0, -1);
        return Math.min(res[0], res[1]);
    }

    private int[] dfs2(int cur, int par) {
        int notHalved = p[cur];
        int halved = p[cur] / 2;
        for (Integer next : tree[cur]) {
            if (next == par) {
                continue;
            }
            int[] res = dfs2(next, cur);
            notHalved += Math.min(res[0], res[1]);
            halved += res[0];
        }
        return new int[]{notHalved, halved};
    }

    private boolean dfs(int cur, int par, int dest) {
        if (cur == dest) {
            count[cur]++;
            return true;
        }
        for (Integer next : tree[cur]) {
            if (next == par) {
                continue;
            }
            if (dfs(next, cur, dest)) {
                count[cur]++;
                return true;
            }
        }
        return false;
    }
}
