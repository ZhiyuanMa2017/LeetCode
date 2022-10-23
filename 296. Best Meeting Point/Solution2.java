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

    private int getDis(List<Integer> list) {
        int n = list.size();
        int mid;
        if (n % 2 == 0) {
            mid = list.get(n / 2) + list.get(n / 2 - 1);
            mid /= 2;
        } else {
            mid = list.get(n / 2);
        }
        int res = 0;
        for (Integer integer : list) {
            res += Math.abs(integer - mid);
        }
        return res;
    }
}
