import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        UF uf = new UF(m * n);
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            ids.add(i);
        }
        Collections.sort(ids, (a, b) -> queries[a] - queries[b]);
        int[][] valuesToPos = new int[m * n][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valuesToPos[i * n + j] = new int[]{i, j, grid[i][j]};
            }
        }
        Arrays.sort(valuesToPos, (a, b) -> a[2] - b[2]);
        int[] res = new int[queries.length];
        int index = 0;
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        for (int id : ids) {
            int query = queries[id];
            while (index < valuesToPos.length && valuesToPos[index][2] < query) {
                int[] cur = valuesToPos[index];
                int x = cur[0];
                int y = cur[1];
                for (int p = 0; p < 4; p++) {
                    int xx = x + dirs[p];
                    int yy = y + dirs[p + 1];
                    if (xx >= 0 && xx < m && yy >= 0 && yy < n && grid[xx][yy] <= grid[x][y]) {
                        uf.union(x * n + y, xx * n + yy);
                    }
                }
                index++;
            }
            if (query > grid[0][0]) {
                res[id] = uf.size[uf.find(0)];
            } else {
                res[id] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxPoints(new int[][]{{1, 2, 3}, {2, 5, 7}, {3, 5, 1}}, new int[]{5, 6, 2});
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
