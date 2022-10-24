import java.util.Arrays;

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] pp = new int[n][2];
        long total = 0;
        for (int i = 0; i < n; i++) {
            pp[i] = new int[]{nums[i], cost[i]};
            total += cost[i];
        }
        Arrays.sort(pp, (a, b) -> a[0] - b[0]);
        long passed = 0;
        int median = 0;
        for (int[] p : pp) {
            passed += p[1];
            if (passed >= (total + 1) / 2) {
                median = p[0];
                break;
            }
        }
        long res = 0;
        for (int[] p : pp) {
            res += p[1] * ((long) Math.abs(p[0] - median));
        }
        return res;
    }
}
