import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == ')') {
            return false;
        }
        if (grid[m - 1][n - 1] == '(') {
            return false;
        }
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[101][101][200];
        queue.offer(new int[]{0, 0, 1});
        visited[0][0][1] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int point = cur[2];
            if (x == m - 1 && y == n - 1 && point == 0) {
                return true;
            }
            if (x + 1 < m) {
                int newP = point + (grid[x + 1][y] == '(' ? 1 : -1);
                if (newP >= 0 && !visited[x + 1][y][newP]) {
                    visited[x + 1][y][newP] = true;
                    queue.offer(new int[]{x + 1, y, newP});
                }
            }
            if (y + 1 < n) {
                int newP = point + (grid[x][y + 1] == '(' ? 1 : -1);
                if (newP >= 0 && !visited[x][y + 1][newP]) {
                    visited[x][y + 1][newP] = true;
                    queue.offer(new int[]{x, y + 1, newP});
                }
            }
        }
        return false;
    }
}
