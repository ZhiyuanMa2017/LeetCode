class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] res = new int[m];
        // 用并查集实现边的合并。初始化一个大小为 n−1 的并查集，并查集中的节点 i 表示题目的边 i→(i+1)。
        // 连一条从 L 到 R 的边，相当于把并查集中的节点 L,L+1,L+2⋯,R−2 合并到并查集中的节点 R−1 上。
        UF uf = new UF(n - 1);
        int count = n - 1;
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int parentR = uf.find(r) - 1;
            int parentL = uf.find(l);
            while (parentL < r) {
                uf.parent[parentL] = parentR;
                parentL = uf.find(parentL + 1);
                count--;
            }
            res[i] = count;
        }
        return res;
    }

    class UF {
        int[] parent;

        UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int i) {
            while (parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
    }
}
