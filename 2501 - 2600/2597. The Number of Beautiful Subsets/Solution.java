import java.util.Arrays;

class Solution {
    int res;

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int[] visited = new int[1010];
        dfs(nums, 0, k, visited);
        return res - 1;
    }

    private void dfs(int[] nums, int index, int k, int[] visited) {
        if (index == nums.length) {
            res++;
            return;
        }
        int res = 0;
        if (nums[index] < k || visited[nums[index] - k] == 0) {
            visited[nums[index]]++;
            dfs(nums, index + 1, k, visited);
            visited[nums[index]]--;
        }
        dfs(nums, index + 1, k, visited);
    }
}
