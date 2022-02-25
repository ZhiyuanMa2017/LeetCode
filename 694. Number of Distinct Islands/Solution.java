import java.util.HashSet;
import java.util.Set;

class Solution {
    int[] dirs;

    public int numDistinctIslands(int[][] grid) {
        dirs = new int[]{-1, 0, 1, 0, -1};
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, '0');
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int x, int y, StringBuilder sb, char c) {
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
            sb.append(c);
            grid[x][y] = 0;
            dfs(grid, x + 1, y, sb, '1');
            dfs(grid, x, y + 1, sb, '2');
            dfs(grid, x - 1, y, sb, '3');
            dfs(grid, x, y - 1, sb, '4');
            sb.append('5');
        }
    }
}
