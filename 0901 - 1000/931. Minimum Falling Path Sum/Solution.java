class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            cur[i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                tmp[j] = cur[j];
                if (j - 1 >= 0) {
                    tmp[j] = Math.min(tmp[j], cur[j - 1]);
                }
                if (j + 1 < n) {
                    tmp[j] = Math.min(tmp[j], cur[j + 1]);
                }
                tmp[j] += matrix[i][j];
            }
            cur = tmp;
        }
        int res = cur[0];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, cur[i]);
        }
        return res;
    }
}
