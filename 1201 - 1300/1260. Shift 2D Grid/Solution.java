import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int len = m * n;
        k = k % len;
        Integer[][] res = new Integer[m][n];
        for (int i = 0; i < len; i++) {
            int index = (i + k) % len;
            res[index / n][index % n] = grid[i / n][i % n];
        }
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            l.add(List.of(res[i]));
        }
        return l;
    }
}
