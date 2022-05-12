class Solution {
    int res;
    int max;

    public int countMaxOrSubsets(int[] nums) {
        res = 0;
        max = 0;
        dfs(nums, 0, 0);
        return res;
    }

    private void dfs(int[] nums, int index, int cur) {
        if (index == nums.length) {
            if (cur > max) {
                max = cur;
                res = 1;
            } else if (cur == max) {
                res++;
            }
            return;
        }
        dfs(nums, index + 1, cur | nums[index]);
        dfs(nums, index + 1, cur);
    }
}
