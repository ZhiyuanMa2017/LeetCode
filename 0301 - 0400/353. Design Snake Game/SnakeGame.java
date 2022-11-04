import java.util.LinkedList;
import java.util.Queue;

class SnakeGame {
    boolean[][] board;
    Queue<int[]> queue;
    int[][] f;
    int index;
    int x;
    int y;

    public SnakeGame(int width, int height, int[][] food) {
        board = new boolean[height][width];
        f = food;
        queue = new LinkedList<>();
        index = 0;
        queue.offer(new int[]{0, 0});
        board[0][0] = true;
        x = 0;
        y = 0;
    }

    public int move(String direction) {
        switch (direction) {
            case "R" -> y += 1;
            case "D" -> x += 1;
            case "L" -> y -= 1;
            case "U" -> x -= 1;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return -1;
        }
        if (index < f.length && x == f[index][0] && y == f[index][1]) {
            if (board[x][y]) {
                return -1;
            }
            index++;
            queue.offer(new int[]{x, y});
            board[x][y] = true;
        } else {
            int[] first = queue.poll();
            if (board[x][y]) {
                if (x == first[0] && y == first[1]) {

                } else {
                    return -1;
                }
            }
            board[first[0]][first[1]] = false;
            queue.offer(new int[]{x, y});
            board[x][y] = true;
        }
        return queue.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
