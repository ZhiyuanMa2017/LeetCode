class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long res = 0;
        int minDiff = Integer.MAX_VALUE;
        int times = 0;
        // no need to care about edges
        // on a tree we can do XOR to two non-direct connected nodes
        // then it's greedy, consider odd or even times
        for (int num : nums) {
            int did = num ^ k;
            res += Math.max(did, num);
            times += did > num ? 1 : 0;
            minDiff = Math.min(minDiff, Math.abs(did - num));
        }
        return times % 2 == 0 ? res : res - minDiff;
    }
}
