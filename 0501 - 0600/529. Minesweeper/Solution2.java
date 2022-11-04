class Solution2 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        }
        dfs(board, i, j);
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        int mine = findMine(board, i, j);
        if (mine > 0) {
            board[i][j] = (char) ('0' + mine);
            return;
        }
        board[i][j] = 'B';
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                    if (board[x][y] == 'E') {
                        dfs(board, x, y);
                    }
                }
            }
        }
    }

    private int findMine(char[][] board, int i, int j) {
        int mine = 0;
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                    if (x == i && y == j) {
                        continue;
                    }
                    if (board[x][y] == 'M') {
                        mine++;
                    }
                }
            }
        }
        return mine;
    }
}
