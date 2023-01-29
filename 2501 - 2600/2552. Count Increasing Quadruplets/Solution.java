class Solution {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        int[][] greater = new int[n][n + 1];
        for (int k = n - 2; k >= 2; k--) {
            for (int num = n; num >= nums[k + 1]; num--) {
                greater[k][num] = greater[k + 1][num];
            }
            for (int num = nums[k + 1] - 1; num >= 1; num--) {
                greater[k][num] = greater[k + 1][num] + 1;
            }
        }
        int[] less = new int[n + 1];
        long res = 0;
        for (int j = 1; j < n - 2; j++) {
            for (int num = nums[j - 1] + 1; num <= n; num++) {
                less[num]++;
            }
            for (int k = j + 1; k < n - 1; k++) {
                if (nums[j] > nums[k]) {
                    res += (long) less[nums[k]] * greater[k][nums[j]];
                }
            }
        }
        return res;
    }
}
