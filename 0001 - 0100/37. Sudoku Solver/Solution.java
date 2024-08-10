class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int r, int c) {
        if (c == 9) {
            return backtrack(board, r + 1, 0);
        }
        if (r == 9) {
            return true;
        }
        if (board[r][c] != '.') {
            return backtrack(board, r, c + 1);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            if (!isValid(board, r, c, ch)) {
                continue;
            }
            board[r][c] = ch;
            if (backtrack(board, r, c + 1)) {
                return true;
            }
            board[r][c] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == ch) {
                return false;
            }
            if (board[r][i] == ch) {
                return false;
            }
        }
        int x = (r / 3) * 3;
        int y = (c / 3) * 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }
}
