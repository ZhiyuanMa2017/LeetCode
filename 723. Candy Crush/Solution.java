class Solution {
    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean crush = false;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c + 2 < n; c++) {
                if (board[r][c] != 0
                        && Math.abs(board[r][c]) == Math.abs(board[r][c + 1])
                        && Math.abs(board[r][c + 1]) == Math.abs(board[r][c + 2])) {
                    board[r][c] = -Math.abs(board[r][c]);
                    board[r][c + 1] = -Math.abs(board[r][c]);
                    board[r][c + 2] = -Math.abs(board[r][c]);
                    crush = true;
                }
            }
        }

        for (int c = 0; c < n; c++) {
            for (int r = 0; r + 2 < m; r++) {
                if (board[r][c] != 0
                        && Math.abs(board[r][c]) == Math.abs(board[r + 1][c])
                        && Math.abs(board[r + 1][c]) == Math.abs(board[r + 2][c])) {
                    board[r][c] = -Math.abs(board[r][c]);
                    board[r + 1][c] = -Math.abs(board[r][c]);
                    board[r + 2][c] = -Math.abs(board[r][c]);
                    crush = true;
                }
            }
        }

        for (int c = 0; c < n; c++) {
            int last = m - 1;
            for (int r = m - 1; r >= 0; r--) {
                if (board[r][c] > 0) {
                    board[last][c] = board[r][c];
                    last--;
                }
            }
            while (last >= 0) {
                board[last][c] = 0;
                last--;
            }
        }
        if (crush) {
            return candyCrush(board);
        }
        return board;
    }
}
