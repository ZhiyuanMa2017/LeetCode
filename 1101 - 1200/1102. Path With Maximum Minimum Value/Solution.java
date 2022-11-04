import java.util.Arrays;

class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] indexes = new int[m * n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                indexes[i * n + j] = new int[]{i, j};
            }
        }
        Arrays.sort(indexes, (a, b) -> grid[b[0]][b[1]] - grid[a[0]][a[1]]);
        boolean[][] visited = new boolean[m][n];
        UF uf = new UF(m * n);
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        for (int[] index : indexes) {
            int i = index[0];
            int j = index[1];
            int cur = i * n + j;
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x >= 0 && y >= 0 && x < m && y < n && visited[x][y]) {
                    uf.union(cur, x * n + y);
                }

            }
            if (uf.find(m * n - 1) == uf.find(0)) {
                return grid[i][j];
            }
        }
        return -1;
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
