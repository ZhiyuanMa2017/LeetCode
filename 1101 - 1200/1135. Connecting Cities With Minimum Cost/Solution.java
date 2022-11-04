import java.util.Arrays;

class Solution {
    public int minimumCost(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        int used = 0;
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        UF uf = new UF(n + 1);
        int res = 0;
        for (int i = 0; i < connections.length; i++) {
            int first = connections[i][0];
            int second = connections[i][1];
            int cost = connections[i][2];
            if (uf.find(first) != uf.find(second)) {
                uf.union(first, second);
                res += cost;
                used++;
            }
        }
        if (used != n - 1) {
            return -1;
        }
        return res;
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
            if (q == p) {
                return;
            }
            if (size[p] >= size[q]) {
                parent[q] = p;
                size[p] += size[q];
            } else {
                parent[p] = q;
                size[q] += size[p];
            }
        }
    }
}
