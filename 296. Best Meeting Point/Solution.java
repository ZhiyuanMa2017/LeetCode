import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    y.add(j);
                }
            }
        }
        return getDis(x) + getDis(y);
    }

    private int getDis(List<Integer> l) {
        int i = 0;
        int j = l.size() - 1;
        int dis = 0;
        while (i < j) {
            dis += l.get(j) - l.get(i);
            j--;
            i++;
        }
        return dis;
    }
}
