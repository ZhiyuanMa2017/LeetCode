class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long res = 0;
        int count = 0;
        int min = 100001;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.abs(matrix[i][j]);
                min = Math.min(min, Math.abs(matrix[i][j]));
                if (matrix[i][j] < 0) {
                    count++;
                }
            }
        }
        if (count % 2 == 0) {
            return res;
        } else {
            return res - min - min;
        }
    }
}
