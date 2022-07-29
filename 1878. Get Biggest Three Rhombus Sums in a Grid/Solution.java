import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                set.add(grid[i][j]);
                int len = 1;
                while (i - len >= 0 && i + len < m && j - len >= 0 && j + len < n) {
                    int sum = 0;
                    for (int k = 0; k < len; k++) {
                        sum += grid[i + len - k][j + k]; // down right
                        sum += grid[i - k][j + len - k]; // up right
                        sum += grid[i - len + k][j - k]; // up left
                        sum += grid[i + k][j - len + k]; // down left
                    }
                    set.add(sum);
                    len++;
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        Collections.reverse(list);
        int[] res;
        if (list.size() >= 3) {
            res = new int[3];
            for (int i = 0; i < 3; i++) {
                res[i] = list.get(i);
            }
        } else {
            res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
        }
        return res;
    }
}
