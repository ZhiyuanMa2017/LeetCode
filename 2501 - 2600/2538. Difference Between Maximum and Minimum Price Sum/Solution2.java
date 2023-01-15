import java.util.ArrayList;

class Solution {
    ArrayList<Integer>[] tree;
    int[] p;

    public long maxOutput(int n, int[][] edges, int[] price) {
        tree = new ArrayList[n];
        p = price;
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        long[] dis = new long[n];
        dis[0] = price[0];
        int one = dfs(0, -1, dis);
        long[] disOne = new long[n];
        disOne[one] = price[one];
        int two = dfs(one, -1, disOne);
        long[] disTwo = new long[n];
        disTwo[two] = price[two];
        dfs(two, -1, disTwo);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, Math.max(disOne[i], disTwo[i]) - price[i]);
        }
        return res;
    }

    private int dfs(int cur, int parent, long[] dis) {
        int res = cur;
        for (Integer next : tree[cur]) {
            if (next == parent) {
                continue;
            }
            dis[next] = dis[cur] + p[next];
            int node = dfs(next, cur, dis);
            if (dis[node] > dis[res]) {
                res = node;
            }
        }
        return res;
    }
}
