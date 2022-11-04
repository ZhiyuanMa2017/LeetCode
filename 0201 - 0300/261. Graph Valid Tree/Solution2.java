class Solution2 {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        UF uf = new UF(n);
        for (int[] edge : edges) {
            if (uf.find(edge[0]) == uf.find(edge[1])) {
                return false;
            }
            uf.union(edge[0], edge[1]);
        }
        return true;
    }

    class UF {

        int[] size;
        int[] parent;

        UF(int n) {
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        int find(int i) {
            while (parent[i] != i) {
                i = parent[parent[i]];
            }
            return i;
        }

        void union(int i, int j) {
            int p = parent[i];
            int q = parent[j];
            if (p == q) {
                return;
            }
            if (size[p] > size[q]) {
                parent[q] = p;
                size[p] += size[q];
            } else {
                parent[p] = q;
                size[q] += size[p];
            }
        }
    }
}
