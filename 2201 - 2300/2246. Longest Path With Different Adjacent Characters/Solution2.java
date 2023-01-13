import java.util.ArrayList;

class Solution {
    ArrayList<Integer>[] tree;
    int res;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        res = 1;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int p = parent[i];
            tree[p].add(i);
        }
        dfs(0, s);
        return res;
    }

    private int dfs(int cur, String s) {
        int max = 0;
        for (Integer next : tree[cur]) {
            int length = dfs(next, s);
            if (s.charAt(cur) != s.charAt(next)) {
                res = Math.max(res, max + length + 1);
                max = Math.max(max, length);
            }
        }
        return max + 1;
    }
}
