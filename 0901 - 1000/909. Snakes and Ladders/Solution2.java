import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        q.offer(1);
        visited[1] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == n * n) {
                    return step;
                }
                for (int next = cur + 1; next <= Math.min(cur + 6, n * n); next++) {
                    int[] pos = valueToPosition(next, n);
                    int ne = next;
                    if (board[pos[0]][pos[1]] > 0) {
                        ne = board[pos[0]][pos[1]];
                    }
                    if (!visited[ne]) {
                        q.offer(ne);
                        visited[ne] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private int[] valueToPosition(int value, int n) {
        int x = (value + n - 1) / n;
        int y = (value - 1) % n;
        int row = n - x;
        int col = x % 2 == 1 ? y : n - 1 - y;
        return new int[]{row, col};
    }
}
