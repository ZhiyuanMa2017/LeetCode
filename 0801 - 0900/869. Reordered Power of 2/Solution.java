class Solution {
    boolean res;

    public boolean reorderedPowerOf2(int n) {
        String num = String.valueOf(n);
        int[] nums = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            nums[i] = num.charAt(i) - '0';
        }
        res = false;

        dfs(nums, 0, new boolean[nums.length], 0);
        return res;
    }

    private void dfs(int[] nums, int cur, boolean[] visited, int count) {
        if (res) {
            return;
        }
        if (count == nums.length) {
            if ((cur & (cur - 1)) == 0 && cur != 0) {
                res = true;
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && cur == 0) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            cur = cur * 10 + nums[i];
            count++;
            dfs(nums, cur, visited, count);
            cur = (cur - nums[i]) / 10;
            count--;
            visited[i] = false;
        }
    }
}
