import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for (int j = 0; j < 4; j++) {
                    int a = x;
                    int b = y;
                    while (a >= 0 && a < m && b >= 0 && b < n && maze[a][b] == 0) {
                        a += dirs[j];
                        b += dirs[j + 1];
                    }
                    a -= dirs[j];
                    b -= dirs[j + 1];
                    if (visited[a][b]) {
                        continue;
                    } else {
                        if (a == destination[0] && b == destination[1]) {
                            return true;
                        }
                        queue.offer(new int[]{a, b});
                        visited[a][b] = true;
                    }
                }
            }
        }
        return false;
    }
}
