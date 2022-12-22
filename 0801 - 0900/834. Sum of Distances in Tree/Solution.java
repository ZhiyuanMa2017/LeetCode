import java.util.ArrayList;

class Solution {
    ArrayList<Integer>[] tree;
    int[] sub;
    int[] dis;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            tree[a].add(b);
            tree[b].add(a);
        }
        sub = new int[n];
        dis = new int[n];
        dfs(0, -1);
        dfs2(0, -1);
        return dis;
    }

    private void dfs(int root, int parent) {
        for (Integer next : tree[root]) {
            if (next == parent) {
                continue;
            }
            dfs(next, root);
            sub[root] += sub[next];
            dis[root] += sub[next] + dis[next];
        }
        sub[root]++;
    }

    private void dfs2(int root, int parent) {
        for (Integer next : tree[root]) {
            if (next == parent) {
                continue;
            }
            int plusOtherOneMove = sub.length - sub[next];
            int minusSubOneMove = dis[root] - sub[next];
            dis[next] = minusSubOneMove + plusOtherOneMove;
            dfs2(next, root);
        }
    }
}
