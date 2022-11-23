class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i)) {
                return false;
            }
            if (!checkCol(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkBox(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkBox(char[][] board, int x, int y) {
        int seen = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int index = board[i][j] - '1';
                if (((seen >> index) & 1) > 0) {
                    return false;
                }
                seen |= 1 << index;
            }
        }
        return true;
    }

    private boolean checkRow(char[][] board, int row) {
        int seen = 0;
        for (char c : board[row]) {
            if (c == '.') {
                continue;
            }
            int index = c - '1';
            if (((seen >> index) & 1) > 0) {
                return false;
            }
            seen |= 1 << index;
        }
        return true;
    }

    private boolean checkCol(char[][] board, int col) {
        int seen = 0;
        for (char[] rows : board) {
            if (rows[col] == '.') {
                continue;
            }
            int index = rows[col] - '1';
            if (((seen >> index) & 1) > 0) {
                return false;
            }
            seen |= 1 << index;
        }
        return true;
    }
}
