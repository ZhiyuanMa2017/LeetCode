import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        return backtracking(nums, 0, nums.length - 1, visited, sum / k, k);
    }

    private boolean backtracking(int[] nums, int curSum, int beginIndex,
                                 boolean[] visited, int target, int remainSetNum) {
        if (remainSetNum == 0) {
            return true;
        }
        if (curSum == target) {
            return backtracking(nums, 0, nums.length - 1, visited, target, remainSetNum - 1);
        }
        for (int i = beginIndex; i >= 0; i--) {
            if (!visited[i] && curSum + nums[i] <= target) {
                visited[i] = true;
                if (backtracking(nums, curSum + nums[i], i - 1, visited, target, remainSetNum)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
