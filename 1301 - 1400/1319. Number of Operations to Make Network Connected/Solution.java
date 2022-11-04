class Solution {
    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        if (len < n - 1) {
            return -1;
        }
        UF uf = new UF(n);
        int res = n;
        for (int[] connection : connections) {
            if (uf.find(connection[0]) != uf.find(connection[1])) {
                res--;
                uf.union(connection[0], connection[1]);
            }
        }
        return res - 1;
    }

    class UF {
        int[] parent;
        int[] size;

        UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        void union(int i, int j) {
            int p = find(i);
            int q = find(j);
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
