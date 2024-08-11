import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int cur = 0;
        int x = 0;
        int y = 0;
        while (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] != 101) {
            res.add(matrix[x][y]);
            matrix[x][y] = 101;
            int i = x + dirs[cur];
            int j = y + dirs[cur + 1];
            if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] == 101) {
                cur = (cur + 1) % 4;
                i = x + dirs[cur];
                j = y + dirs[cur + 1];
            }
            x = i;
            y = j;
        }
        return res;
    }
}
