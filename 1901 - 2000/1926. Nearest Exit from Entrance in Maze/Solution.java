import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dir = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);
        int steps = 0;
        maze[entrance[0]][entrance[1]] = '+';
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] d : dir) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if (x >= 0 && x <= m - 1 && y >= 0 && y <= n - 1 && maze[x][y] == '.') {
                        queue.add(new int[]{x, y});
                        if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                            return steps;
                        }
                        maze[x][y] = '+';
                    }
                }
            }
        }
        return -1;
    }
}
