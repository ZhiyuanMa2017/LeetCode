import java.util.ArrayList;

class Solution {
    int[] res;
    ArrayList<Integer>[] tree;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        res = new int[n];
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        dfs(0, -1, labels);
        return res;
    }

    private int[] dfs(int cur, int parent, String labels) {
        int[] count = new int[26];
        for (Integer next : tree[cur]) {
            if (next == parent) {
                continue;
            }
            int[] child = dfs(next, cur, labels);
            for (int i = 0; i < 26; i++) {
                count[i] += child[i];
            }
        }
        int index = labels.charAt(cur) - 'a';
        count[index]++;
        res[cur] = count[index];
        return count;
    }
}
