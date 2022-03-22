class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat2.length;
        int n = mat2[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = add(mat1, i, mat2, j);
            }
        }
        return res;
    }

    private int add(int[][] mat1, int i, int[][] mat2, int j) {
        int res = 0;
        int k = mat1[0].length;
        for (int index = 0; index < k; index++) {
            if (mat1[i][index] == 0) {
                continue;
            }
            res += mat1[i][index] * mat2[index][j];
        }
        return res;
    }
}
