class Solution {
    Integer[][] memo;

    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        memo = new Integer[m][m];
        int start = 0;
        int i = 0;
        return dfs(nums, multipliers, start, i);
    }

    private int dfs(int[] nums, int[] multipliers, int start, int i) {
        if (i == multipliers.length) {
            return 0;
        }
        int end = nums.length - 1 - (i - start);
        if (memo[start][i] != null) {
            return memo[start][i];
        }
        int chooseLeft = dfs(nums, multipliers, start + 1, i + 1) + nums[start] * multipliers[i];
        int chooseRight = dfs(nums, multipliers, start, i + 1) + nums[end] * multipliers[i];
        memo[start][i] = Math.max(chooseLeft, chooseRight);
        return memo[start][i];
    }
}
