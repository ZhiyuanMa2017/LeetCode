import java.util.Arrays;

class Solution {
    int res;

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[1010];
        dfs(nums, 0, k, visited);
        return res - 1;
    }

    private void dfs(int[] nums, int index, int k, boolean[] visited) {
        if (index == nums.length) {
            res++;
            return;
        }
        if (nums[index] < k || !visited[nums[index] - k]) {
            visited[nums[index]] = true;
            dfs(nums, index + 1, k, visited);
            visited[nums[index]] = false;
        }
        dfs(nums, index + 1, k, visited);
    }
}
