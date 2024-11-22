import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[][] minScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<int[]> nums = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums.add(new int[]{grid[i][j], i, j});
            }
        }
        Collections.sort(nums, (a, b) -> a[0] - b[0]);
        int[] rows = new int[m];
        int[] cols = new int[n];
        Arrays.fill(rows, 1);
        Arrays.fill(cols, 1);
        for (int[] num : nums) {
            int i = num[1];
            int j = num[2];
            grid[i][j] = Math.max(rows[i], cols[j]);
            rows[i] = grid[i][j] + 1;
            cols[j] = grid[i][j] + 1;
        }
        return grid;
    }
}
