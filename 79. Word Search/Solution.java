class Solution {
    private char[][] b;
    private String w;
    private final int[] dirs = new int[]{0, 1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        b = board;
        w = word;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i][j] == w.charAt(0)) {
                    if (backtracking(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtracking(int i, int j, int index) {
        if (index == w.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= b.length || j >= b[0].length) {
            return false;
        }
        if (w.charAt(index) != b[i][j]) {
            return false;
        }
        b[i][j] = '+';
        for (int k = 0; k < 4; k++) {
            if (backtracking(i + dirs[k], j + dirs[k + 1], index + 1)) {
                return true;
            }
        }
        b[i][j] = w.charAt(index);
        return false;
    }
}
