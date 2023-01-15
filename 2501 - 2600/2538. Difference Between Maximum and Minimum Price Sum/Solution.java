import java.util.ArrayList;

class Solution {
    ArrayList<Integer>[] tree;
    int[] p;
    long res;

    public long maxOutput(int n, int[][] edges, int[] price) {
        tree = new ArrayList[n];
        res = 0;
        p = price;
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        dfs(0, -1);
        return res;
    }

    private long[] dfs(int cur, int parent) {
        long sumWith = p[cur];
        long sumWithout = 0;
        for (Integer next : tree[cur]) {
            if (next == parent) {
                continue;
            }
            long[] sums = dfs(next, cur);
            long s1 = sums[0];
            long s2 = sums[1];
            res = Math.max(res, Math.max(s1 + sumWithout, s2 + sumWith));
            sumWith = Math.max(sumWith, s1 + p[cur]);
            sumWithout = Math.max(sumWithout, s2 + p[cur]);
        }
        return new long[]{sumWith, sumWithout};
    }
}
