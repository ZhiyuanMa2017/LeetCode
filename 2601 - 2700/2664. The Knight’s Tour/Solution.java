import java.util.Arrays;

class Solution {
    int[][] dirs = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

    public int[][] tourOfKnight(int m, int n, int r, int c) {
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(board[i], -1);
        }
        board[r][c] = 0;
        backtrack(board, r, c, 1);
        return board;
    }

    private boolean backtrack(int[][] board, int x, int y, int cur) {
        int m = board.length;
        int n = board[0].length;
        if (cur == m * n) {
            return true;
        }
        for (int[] dir : dirs) {
            int a = x + dir[0];
            int b = y + dir[1];
            if (a >= 0 && a < m && b >= 0 && b < n && board[a][b] == -1) {
                board[a][b] = cur;
                if (backtrack(board, a, b, cur + 1)) {
                    return true;
                }
                board[a][b] = -1;
            }
        }
        return false;
    }
}
