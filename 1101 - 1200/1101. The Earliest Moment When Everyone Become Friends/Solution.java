import java.util.Arrays;

class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        UF uf = new UF(n);
        for (int[] log : logs) {
            int time = log[0];
            int first = log[1];
            int second = log[2];
            if (uf.find(first) == uf.find(second)) {
                continue;
            }
            uf.union(first, second);
            if (uf.max == n) {
                return time;
            }
        }
        return -1;
    }

    class UF {
        int[] parent;
        int[] size;
        int max;

        UF(int n) {
            parent = new int[n];
            size = new int[n];
            max = 1;
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
            } else if (size[p] > size[q]) {
                parent[q] = p;
                size[p] += size[q];
                max = Math.max(max, size[p]);
            } else {
                parent[p] = q;
                size[q] += size[p];
                max = Math.max(max, size[q]);
            }
        }
    }
}
