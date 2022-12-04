class Solution {
    public int minScore(int n, int[][] roads) {
        UF uf = new UF(n + 1);
        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];
            int s = road[2];
            uf.union(start, end);
        }
        int res = Integer.MAX_VALUE;
        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];
            int s = road[2];
            if (uf.find(1) == uf.find(start)) {
                res = Math.min(res, s);
            }
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
