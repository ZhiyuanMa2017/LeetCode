import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][]{{1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        visited[click[0]][click[1]] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = 0;
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                    if (board[newX][newY] == 'M') {
                        count++;
                    }
                }
            }
            if (count > 0) {
                board[x][y] = (char) (count + '0');
            } else {
                board[x][y] = 'B';
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                        if (!visited[newX][newY] && board[newX][newY] == 'E') {
                            queue.offer(new int[]{newX, newY});
                            visited[newX][newY] = true;
                        }
                    }
                }
            }

        }
        return board;
    }
}
