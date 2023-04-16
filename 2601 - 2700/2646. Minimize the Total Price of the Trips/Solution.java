import java.util.ArrayList;
import java.util.Arrays;
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
        dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        p = price;
        return Math.min(dfs2(0, -1, 1), dfs2(0, -1, 0));
    }

    private int dfs2(int cur, int par, int halved) {
        if (dp[cur][halved] != Integer.MAX_VALUE) {
            return dp[cur][halved];
        }
        if (halved == 1) {
            dp[cur][halved] = p[cur] / 2;
        } else {
            dp[cur][halved] = p[cur];
        }
        for (Integer next : tree[cur]) {
            if (next == par) {
                continue;
            }
            if (halved == 1) {
                dp[cur][halved] += dfs2(next, cur, 0);
            } else {
                dp[cur][halved] += Math.min(dfs2(next, cur, 0), dfs2(next, cur, 1));
            }
        }
        return dp[cur][halved];
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
