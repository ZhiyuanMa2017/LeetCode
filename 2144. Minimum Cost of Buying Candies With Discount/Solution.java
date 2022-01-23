import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res = 0;
        for (int i = cost.length - 1; i >= 0; i -= 3) {
            res += cost[i];
            if (i - 1 >= 0) {
                res += cost[i - 1];
            }
        }
        return res;
    }
}
