import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int step = 0;
        boolean[] visited = new boolean[n * n + 1];
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (visited[cur]) {
                    continue;
                }
                visited[cur] = true;
                if (cur == n * n) {
                    return step;
                }
                int ceiling = Math.min(cur + 6, n * n);
                for (int next = cur + 1; next <= ceiling; next++) {
                    int value = change(next, board);
                    int cell = value > 0 ? value : next;
                    if (!visited[cell]) {
                        q.offer(cell);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private int change(int i, int[][] board) {
        int n = board.length;
        int row = (i + n - 1) / n;
        int col = (i - 1) % n;
        int x = n - row;
        int y = row % 2 == 0 ? n - 1 - col : col;
        return board[x][y];
    }
}
