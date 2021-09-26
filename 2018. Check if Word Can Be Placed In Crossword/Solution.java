class Solution {
    char[][] thisBoard;
    String thisString;

    public boolean placeWordInCrossword(char[][] board, String word) {
        this.thisBoard = board;
        this.thisString = word;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (check(i, 0, 0, 1) || check(i, n - 1, 0, -1)) {
                return true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (check(0, i, 1, 0) || check(m - 1, i, -1, 0)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(int r, int c, int dr, int dc) {
        int p = 0;
        while (r >= 0 && r < thisBoard.length && c >= 0 && c < thisBoard[0].length) {
            if (thisBoard[r][c] == '#') {
                if (p == thisString.length()) {
                    break;
                }
                p = 0;
            } else if (p == -1) {
                continue;
            } else if (p == thisString.length()) {
                p = -1;
            } else if (thisBoard[r][c] != ' ' && thisBoard[r][c] != thisString.charAt(p)) {
                p = -1;
            } else {
                p++;
            }
            r += dr;
            c += dc;
        }
        return p == thisString.length();
    }
}
