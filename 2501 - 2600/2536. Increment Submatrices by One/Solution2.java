class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        int[][] diff = new int[n + 1][n + 1];
        for (int[] query : queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];
            diff[row1][col1] += 1;
            diff[row1][col2 + 1] -= 1;
            diff[row2 + 1][col1] -= 1;
            diff[row2 + 1][col2 + 1] += 1;
        }
        res[0][0] = diff[0][0];
        for (int i = 1; i < n; i++) {
            diff[i][0] += diff[i - 1][0];
            res[i][0] = diff[i][0];
        }
        for (int j = 1; j < n; j++) {
            diff[0][j] += diff[0][j - 1];
            res[0][j] = diff[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
                res[i][j] = diff[i][j];
            }
        }
        return res;
    }
}
