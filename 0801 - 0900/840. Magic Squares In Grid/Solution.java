class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (row < 3 || col < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i + 2 < row; i++) {
            for (int j = 0; j + 2 < col; j++) {
                if (valid(i, j, grid)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean valid(int i, int j, int[][] grid) {
        int bit = 0;
        for (int x = i; x < i + 3; x++) {
            for (int y = j; y < j + 3; y++) {
                bit |= 1 << grid[x][y];
            }
        }
        if (bit != 0b1111111110) {
            return false;
        }
        boolean valid = true;
        valid &= (grid[i][j] + grid[i + 1][j] + grid[i + 2][j] == 15);
        valid &= (grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] == 15);
        valid &= (grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] == 15);

        valid &= (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] == 15);
        valid &= (grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] == 15);
        valid &= (grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] == 15);

        valid &= (grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] == 15);

        valid &= (grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] == 15);

        return valid;
    }
}
