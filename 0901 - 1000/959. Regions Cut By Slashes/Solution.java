class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid[0].length();
        int m = n * n * 4;
        UF uf = new UF(m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    uf.union(pos(i - 1, j, 2, n), pos(i, j, 0, n));
                }
                if (j > 0) {
                    uf.union(pos(i, j - 1, 1, n), pos(i, j, 3, n));
                }
                if (grid[i].charAt(j) != '/') {
                    uf.union(pos(i, j, 0, n), pos(i, j, 1, n));
                    uf.union(pos(i, j, 2, n), pos(i, j, 3, n));
                }
                if (grid[i].charAt(j) != '\\') {
                    uf.union(pos(i, j, 0, n), pos(i, j, 3, n));
                    uf.union(pos(i, j, 2, n), pos(i, j, 1, n));
                }
            }
        }
        return uf.count;
    }

    private int pos(int i, int j, int k, int n) {
        return (i * n + j) * 4 + k;
    }

    class UF {
        int count;
        int[] parent;
        int[] size;

        UF(int n) {
            count = n;
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
            if (size[p] >= size[q]) {
                parent[q] = p;
                size[p] += size[q];
            } else {
                parent[p] = q;
                size[q] += parent[p];
            }
            count--;
        }
    }
}
