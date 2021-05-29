import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<List<String>> res = new ArrayList<>();
    int[] queens;
    Set<Integer> columns = new HashSet<>();
    Set<Integer> diagonal = new HashSet<>();
    Set<Integer> diagonal2 = new HashSet<>();

    public int totalNQueens(int n) {
        queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(n, 0);
        return res.size();
    }

    private void backtrack(int n, int row) {
        if (row == n) {
            List<String> board = generateBoard(n);
            res.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                int d1 = row + i;
                int d2 = row - i;
                if (!columns.contains(i) && !diagonal.contains(d1) && !diagonal2.contains(d2)) {
                    queens[row] = i;
                    columns.add(i);
                    diagonal.add(d1);
                    diagonal2.add(d2);
                    backtrack(n, row + 1);
                    queens[row] = -1;
                    columns.remove(i);
                    diagonal.remove(d1);
                    diagonal2.remove(d2);
                }
            }
        }

    }

    private List<String> generateBoard(int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] c = new char[n];
            Arrays.fill(c, '.');
            c[queens[i]] = 'Q';
            board.add(new String(c));
        }
        return board;
    }
}
