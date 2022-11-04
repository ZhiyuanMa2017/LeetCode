class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        int index = 0;
        res[index] = new int[]{rStart, cStart};
        index++;
        int step = 1;
        int x = rStart;
        int y = cStart;
        while (index < rows * cols) {
            for (int i = 0; i < step; i++) {
                y++;
                if (inBound(x, y, rows, cols)) {
                    res[index] = new int[]{x, y};
                    index++;
                }
            }
            for (int i = 0; i < step; i++) {
                x++;
                if (inBound(x, y, rows, cols)) {
                    res[index] = new int[]{x, y};
                    index++;
                }
            }
            step++;
            for (int i = 0; i < step; i++) {
                y--;
                if (inBound(x, y, rows, cols)) {
                    res[index] = new int[]{x, y};
                    index++;
                }
            }
            for (int i = 0; i < step; i++) {
                x--;
                if (inBound(x, y, rows, cols)) {
                    res[index] = new int[]{x, y};
                    index++;
                }
            }
            step++;
        }
        return res;
    }

    private boolean inBound(int x, int y, int rows, int cols) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }
}
