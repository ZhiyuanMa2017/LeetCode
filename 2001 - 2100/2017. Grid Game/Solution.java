class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long topRight = 0;
        long bottomLeft = 0;
        for (int i = 1; i < n; i++) {
            topRight += grid[0][i];
        }
        long res = Math.max(topRight, bottomLeft);
        for (int i = 1; i < n; i++) {
            topRight -= grid[0][i];
            bottomLeft += grid[1][i - 1];
            res = Math.min(res, Math.max(topRight, bottomLeft));
        }
        return res;
    }
}
