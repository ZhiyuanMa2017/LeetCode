import java.util.HashMap;
import java.util.Map;

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UF uf = new UF(n);
        Map<Integer, Integer> x = new HashMap<>();
        Map<Integer, Integer> y = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = stones[i][0];
            int b = stones[i][1];
            if (x.containsKey(a)) {
                uf.union(i, x.get(a));
            } else {
                x.put(a, i);
            }
            if (y.containsKey(b)) {
                uf.union(i, y.get(b));
            } else {
                y.put(b, i);
            }
        }
        return n - uf.total;
    }

    class UF {
        int[] parent;
        int[] size;
        int total;

        UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            total = n;
        }

        public int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int p = find(i);
            int q = find(j);
            if (q == p) {
                return;
            }
            total--;
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
