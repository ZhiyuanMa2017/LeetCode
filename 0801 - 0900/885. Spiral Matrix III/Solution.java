class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        int index = 0;
        res[0] = new int[]{rStart, cStart};
        index++;
        int step = 1;
        int r = rStart;
        int c = cStart;
        while (index < rows * cols) {
            for (int i = 0; i < step; i++) {
                c = c + 1;
                if (inBound(r, c, rows, cols)) {
                    res[index] = new int[]{r, c};
                    index++;
                    if (index == rows * cols) {
                        return res;
                    }
                }
            }
            for (int i = 0; i < step; i++) {
                r = r + 1;
                if (inBound(r, c, rows, cols)) {
                    res[index] = new int[]{r, c};
                    index++;
                    if (index == rows * cols) {
                        return res;
                    }
                }
            }
            step++;
            for (int i = 0; i < step; i++) {
                c = c - 1;
                if (inBound(r, c, rows, cols)) {
                    res[index] = new int[]{r, c};
                    index++;
                    if (index == rows * cols) {
                        return res;
                    }
                }
            }
            for (int i = 0; i < step; i++) {
                r = r - 1;
                if (inBound(r, c, rows, cols)) {
                    res[index] = new int[]{r, c};
                    index++;
                    if (index == rows * cols) {
                        return res;
                    }
                }
            }
            step++;
        }
        return res;
    }

    private boolean inBound(int r, int c, int rows, int cols) {
        return r >= 0 && c >= 0 && r < rows && c < cols;
    }
}
