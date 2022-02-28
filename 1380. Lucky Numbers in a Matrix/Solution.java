import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        Arrays.fill(rows, 100001);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] = Math.min(rows[i], matrix[i][j]);
                cols[j] = Math.max(cols[j], matrix[i][j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == rows[i] && rows[i] == cols[j]) {
                    res.add(cols[j]);
                    break;
                }
            }
            if (res.size() > 0) {
                break;
            }
        }
        return res;
    }
}
