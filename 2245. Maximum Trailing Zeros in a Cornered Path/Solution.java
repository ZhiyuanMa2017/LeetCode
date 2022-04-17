class Solution {
    public int maxTrailingZeros(int[][] grid) {
        int res = 0;
        for (int i = 0; i < 4; i++) {
            grid = rotate(grid);
            res = Math.max(res, count(grid));
        }
        return res;
    }

    private int[][] rotate(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] copy = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[j][n - 1 - i] = grid[i][j];
            }
        }
        return copy;
    }

    private int count(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] twoRow = new int[n][m];
        int[][] fiveRow = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j >= 1) {
                    twoRow[i][j] = twoRow[i][j - 1];
                    fiveRow[i][j] = fiveRow[i][j - 1];
                }
                int val = grid[i][j];
                twoRow[i][j] += count2(val);
                fiveRow[i][j] += count5(val);
            }
        }

        int[][] twoCol = new int[n][m];
        int[][] fiveCol = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i >= 1) {
                    twoCol[i][j] = twoCol[i - 1][j];
                    fiveCol[i][j] = fiveCol[i - 1][j];
                }
                int val = grid[i][j];
                twoCol[i][j] += count2(val);
                fiveCol[i][j] += count5(val);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int two = twoRow[i][j] + twoCol[i][j];
                int five = fiveRow[i][j] + fiveCol[i][j];
                int val = grid[i][j];
                int commonTwo = count2(val);
                int commonFive = count5(val);
                two -= commonTwo;
                five -= commonFive;
                res = Math.max(res, Math.min(two, five));
            }
        }
        return res;
    }

    private int count2(int v) {
        int res = 0;
        while (v % 2 == 0) {
            v /= 2;
            res++;
        }
        return res;
    }

    private int count5(int v) {
        int res = 0;
        while (v % 5 == 0) {
            v /= 5;
            res++;
        }
        return res;
    }
}
