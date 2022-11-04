import java.util.Arrays;

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] pp = new int[n][2];
        for (int i = 0; i < n; i++) {
            pp[i] = new int[]{nums[i], cost[i]};
        }
        Arrays.sort(pp, (a, b) -> a[0] - b[0]);
        long[] total = new long[n];
        long cur = pp[0][1];
        for (int i = 1; i < n; i++) {
            total[i] = total[i - 1] + cur * (pp[i][0] - pp[i - 1][0]);
            cur += pp[i][1];
        }
        cur = pp[n - 1][1];
        long res = total[n - 1];
        long count = 0;
        for (int i = n - 2; i >= 0; i--) {
            count += cur * (pp[i + 1][0] - pp[i][0]);
            res = Math.min(res, total[i] + count);
            cur += pp[i][1];
        }

        return res;
    }
}
