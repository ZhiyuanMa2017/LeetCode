import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int x = 0;
        int y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (grid[cur[0]][cur[1]] == '#') {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    int newX = cur[0] + dirs[j];
                    int newY = cur[1] + dirs[j + 1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n
                            && grid[newX][newY] != 'X' && !visited[newX][newY]) {
                        q.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
