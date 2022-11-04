import java.util.Arrays;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[n * m];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[index] = grid[i][j];
                index++;
            }
        }
        Arrays.sort(arr);
        int mid = arr[n * m / 2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diff = Math.abs(grid[i][j] - mid);
                if (diff % x != 0) {
                    return -1;
                }
                res += diff / x;
            }
        }
        return res;
    }
}
