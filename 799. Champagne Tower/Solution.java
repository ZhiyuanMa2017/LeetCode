class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[101][102];
        glasses[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j < i + 1; j++) {
                double cur = glasses[i][j];
                cur = (cur - 1) / 2;
                if (cur > 0) {
                    glasses[i + 1][j] += cur;
                    glasses[i + 1][j + 1] += cur;
                }
            }
        }
        return Math.min(1, glasses[query_row][query_glass]);
    }
}
