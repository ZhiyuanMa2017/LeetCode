import java.util.Arrays;

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        int used = 0;
        UF a = new UF(n + 1);
        UF b = new UF(n + 1);
        for (int[] edge : edges) {
            int u = edge[1];
            int v = edge[2];
            boolean cur = false;
            if (edge[0] == 3 || edge[0] == 1) {
                if (a.find(u) != a.find(v)) {
                    a.union(u, v);
                    cur = true;
                }
            }
            if (edge[0] == 3 || edge[0] == 2) {
                if (b.find(u) != b.find(v)) {
                    b.union(u, v);
                    cur = true;
                }
            }
            if (cur) {
                used++;
            }
        }
        if (a.count == 2 && b.count == 2) {
            return edges.length - used;
        }
        return -1;
    }

    class UF {
        int[] parent;
        int[] size;
        int count;

        UF(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            count = n;
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
            if (p == q) {
                return;
            }
            count--;
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
