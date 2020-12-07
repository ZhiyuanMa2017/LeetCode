class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                res[rowStart][i] = num;
                num++;
            }
            rowStart++;
            for (int j = rowStart; j <= rowEnd; j++) {
                res[j][colEnd] = num;
                num++;
            }
            colEnd--;
            for (int h = colEnd; h >= colStart; h--) {
                res[rowEnd][h] = num;
                num++;
            }
            rowEnd--;
            for (int k = rowEnd; k >= rowStart; k--) {
                res[k][colStart] = num;
                num++;
            }
            colStart++;
        }
        return res;
    }
}