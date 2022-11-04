class Solution {
    int res;

    public int subsetXORSum(int[] nums) {
        res = 0;
        dfs(nums, 0, 0);
        return res;
    }

    private void dfs(int[] nums, int start, int cur) {
        if (start == nums.length) {
            res += cur;
        }
        dfs(nums, start + 1, cur ^ nums[start]);
        dfs(nums, start + 1, cur);
    }
}
