import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!seen.add(board[i][j] + " row " + i)
                            || !seen.add(board[i][j] + " column " + j)
                            || !seen.add(board[i][j] + " " + i / 3 + " box " + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
