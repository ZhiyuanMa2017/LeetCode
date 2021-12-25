import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> res = new ArrayList<>();
        res.add(n - 1);
        int min = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (heights[i] > min) {
                res.add(i);
                min = heights[i];
            }
        }
        int[] result = new int[res.size()];
        int m = res.size();
        for (int i = 0; i < m; i++) {
            result[i] = res.get(m - 1 - i);
        }
        return result;
    }
}
