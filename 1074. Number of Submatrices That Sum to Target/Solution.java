import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                Map<Integer, Integer> curSumMap = new HashMap<>();
                int curSum = 0;
                curSumMap.put(0, 1);

                for (int k = 0; k < m; k++) {
                    curSum += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    res += curSumMap.getOrDefault(curSum - target, 0);
                    curSumMap.put(curSum, curSumMap.getOrDefault(curSum, 0) + 1);
                }
            }
        }
        return res;
    }
}
