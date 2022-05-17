import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] q = new boolean[8][8];
        for (int[] queen : queens) {
            q[queen[0]][queen[1]] = true;
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {-1, -1}, {1, 1}, {0, 1}, {0, -1}, {-1, 1}, {1, -1}};
        List<List<Integer>> res = new ArrayList<>();
        for (int[] dir : dirs) {
            int x = king[0];
            int y = king[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (q[x][y]) {
                    List<Integer> l = new ArrayList<>();
                    l.add(x);
                    l.add(y);
                    res.add(l);
                    break;
                }
                x += dir[0];
                y += dir[1];
            }
        }
        return res;
    }
}
