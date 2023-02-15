import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UF uf = new UF(n * m);
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        for (int[] position : positions) {
            int i = position[0];
            int j = position[1];
            int index = i * n + j;
            if (uf.land[index]) {
                res.add(count);
                continue;
            }
            uf.land[index] = true;
            count++;
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int index2 = x * n + y;
                    if (uf.land[index2]) {
                        if (uf.find(index2) != uf.find(index)) {
                            count--;
                            uf.union(index2, index);
                        }
                    }
                }
            }
            res.add(count);
        }
        return res;
    }

    class UF {
        int[] parent;
        int[] size;
        boolean[] land;

        UF(int n) {
            parent = new int[n];
            size = new int[n];
            land = new boolean[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
                land[i] = false;
            }
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
