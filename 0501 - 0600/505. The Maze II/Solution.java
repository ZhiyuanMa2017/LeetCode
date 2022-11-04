import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        int m = maze.length;
        int n = maze[0].length;
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        queue.offer(start);
        dis[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int a = x;
                int b = y;
                int count = 0;
                while (a >= 0 && a < m && b >= 0 && b < n && maze[a][b] != 1) {
                    a += dirs[i];
                    b += dirs[i + 1];
                    count++;
                }
                a -= dirs[i];
                b -= dirs[i + 1];
                count--;
                if (dis[x][y] + count < dis[a][b]) {
                    dis[a][b] = dis[x][y] + count;
                    queue.offer(new int[]{a, b});
                }
            }
        }
        return dis[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dis[destination[0]][destination[1]];
    }
}
