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
        for (int i = r; i < 9; i++) {
            for (int j = c; j < 9; j++) {
                if (board[r][c] != '.') {
                    return backtrack(board, i, j + 1);
                }
                for (char ch = '1'; ch <= '9'; ch++) {
                    if (!isValid(board, i, j, ch)) {
                        continue;
                    }
                    board[i][j] = ch;
                    if (backtrack(board, i, j + 1)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
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
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == ch) {
                return false;
            }
        }
        return true;
    }
}
