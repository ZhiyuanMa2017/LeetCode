import java.util.Arrays;

class Solution2 {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res = 0;
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            if (i % 3 != n % 3) {
                res += cost[i];
            }
        }
        return res;
    }
}
