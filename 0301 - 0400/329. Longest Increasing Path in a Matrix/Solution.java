class Solution {
    private static final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int tempMax = 1;
        int[][] maxLength = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int thisMax = dfs(matrix, i, j, maxLength);
                tempMax = Math.max(thisMax, tempMax);
            }
        }
        return tempMax;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] maxLength) {
        if (maxLength[i][j] != 0) {
            return maxLength[i][j];
        }
        int tempMax = 1;
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || x > matrix.length - 1
                    || y < 0 || y > matrix[0].length - 1 || matrix[i][j] >= matrix[x][y]) {
                continue;
            }
            int thisTimeLength = 1 + dfs(matrix, x, y, maxLength);
            tempMax = Math.max(tempMax, thisTimeLength);
        }
        maxLength[i][j] = tempMax;
        return tempMax;
    }
}
