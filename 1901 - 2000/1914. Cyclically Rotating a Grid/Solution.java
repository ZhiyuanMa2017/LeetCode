class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int top = 0;
        int left = 0;
        int right = grid[0].length - 1;
        int bottom = grid.length - 1;
        while (top < bottom && left < right) {
            int circumference = (right - left + bottom - top) * 2;
            int move = k % circumference;
            while (move > 0) {
                int first = grid[top][left];
                for (int j = left; j < right; j++) {
                    grid[top][j] = grid[top][j + 1];
                }
                for (int i = top; i < bottom; i++) {
                    grid[i][right] = grid[i + 1][right];
                }
                for (int j = right; j > left; j--) {
                    grid[bottom][j] = grid[bottom][j - 1];
                }
                for (int i = bottom; i > top; i--) {
                    grid[i][left] = grid[i - 1][left];
                }
                grid[top + 1][left] = first;
                move--;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return grid;
    }
}
