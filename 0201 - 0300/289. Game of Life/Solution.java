class Solution {
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        // 0 dead
        // 1 live
        // 2 live to dead
        // 3 dead to live

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, m); k++) {
                    for (int l = Math.max(j - 1, 0); l < Math.min(j + 2, n); l++) {
                        if (k == i && l == j) {
                            continue;
                        } else {
                            if (board[k][l] == 1 || board[k][l] == 2) {
                                live++;
                            }
                        }
                    }
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
