import java.util.Arrays;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int totalA = 0;
        for (int[] cost : costs) {
            totalA += cost[0];
        }
        int[] refund = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            refund[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(refund);
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            totalA += refund[i];
        }
        return totalA;
    }
}
