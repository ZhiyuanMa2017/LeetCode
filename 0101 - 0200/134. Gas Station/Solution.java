class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int minLeft = Integer.MAX_VALUE;
        int curMin = 0;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            curMin += gas[i] - cost[i];
            if (curMin < minLeft) {
                minIndex = i;
                minLeft = curMin;
            }
        }
        return curMin < 0 ? -1 : (minIndex + 1) % n;
    }
}
