public class Solution20211006 {
    char[][] b;
    String w;
    int[] dirs = new int[]{0, 1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        b = board;
        w = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
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
        char tmp = b[i][j];
        b[i][j] = '*';
        for (int k = 0; k < 4; k++) {
            int x = i + dirs[k];
            int y = j + dirs[k + 1];
            if (backtracking(x, y, index + 1)) {
                return true;
            }
        }
        b[i][j] = tmp;
        return false;
    }
}
