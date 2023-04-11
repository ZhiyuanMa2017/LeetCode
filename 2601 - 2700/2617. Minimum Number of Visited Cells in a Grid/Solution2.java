import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.TreeSet;

class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer>[] row = new TreeSet[m];
        TreeSet<Integer>[] col = new TreeSet[n];
        for (int i = 0; i < m; i++) {
            row[i] = new TreeSet<>();
        }
        for (int j = 0; j < n; j++) {
            col[j] = new TreeSet<>();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i].add(j);
                col[j].add(i);
            }
        }
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], -1);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        dis[0][0] = 1;
        row[0].remove(0);
        col[0].remove(0);
        // so many log: higher, remove
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            Integer ny = row[x].higher(y);
            while (ny != null && ny <= y + grid[x][y]) {
                queue.offer(new int[]{x, ny});
                dis[x][ny] = dis[x][y] + 1;
                col[ny].remove(x);
                row[x].remove(ny);
                ny = row[x].higher(y);
            }
            Integer nx = col[y].higher(x);
            while (nx != null && nx <= x + grid[x][y]) {
                queue.offer(new int[]{nx, y});
                dis[nx][y] = dis[x][y] + 1;
                row[nx].remove(y);
                col[y].remove(nx);
                nx = col[y].higher(x);
            }
        }
        return dis[m - 1][n - 1];
    }
}
