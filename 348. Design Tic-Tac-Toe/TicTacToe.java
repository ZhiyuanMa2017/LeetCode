class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonals;
    int antiDiagonals;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonals = 0;
        antiDiagonals = 0;
    }

    public int move(int row, int col, int player) {
        int cur = player == 1 ? 1 : -1;
        int target = player == 1 ? rows.length : -rows.length;
        rows[row] += cur;
        if (rows[row] == target) {
            return player;
        }
        cols[col] += cur;
        if (cols[col] == target) {
            return player;
        }
        if (row == col) {
            diagonals += cur;
            if (diagonals == target) {
                return player;
            }
        }
        if (row + col == rows.length - 1) {
            antiDiagonals += cur;
            if (antiDiagonals == target) {
                return player;
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
