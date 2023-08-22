class Solution {
    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean crush = true;
        while (crush) {
            crush = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 0) {
                        continue;
                    }
                    if (i + 2 < m) {
                        if (Math.abs(board[i][j]) == Math.abs(board[i + 1][j]) && Math.abs(board[i + 1][j]) == Math.abs(board[i + 2][j])) {
                            board[i][j] = -Math.abs(board[i][j]);
                            board[i + 1][j] = -Math.abs(board[i][j]);
                            board[i + 2][j] = -Math.abs(board[i][j]);
                            crush = true;
                        }
                    }
                    if (j + 2 < n) {
                        if (Math.abs(board[i][j]) == Math.abs(board[i][j + 1]) && Math.abs(board[i][j + 1]) == Math.abs(board[i][j + 2])) {
                            board[i][j] = -Math.abs(board[i][j]);
                            board[i][j + 1] = -Math.abs(board[i][j]);
                            board[i][j + 2] = -Math.abs(board[i][j]);
                            crush = true;
                        }
                    }
                }
            }
            if (crush) {
                for (int j = 0; j < n; j++) {
                    int index = m - 1;
                    int i = m - 1;
                    while (i >= 0) {
                        if (board[i][j] > 0) {
                            board[index][j] = board[i][j];
                            index--;
                        }
                        i--;
                    }
                    while (index >= 0) {
                        board[index][j] = 0;
                        index--;
                    }
                }
            }
        }
        return board;
    }
}
