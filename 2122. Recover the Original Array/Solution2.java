import java.util.Arrays;

class Solution2 {
    public int[] recoverArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            int k = nums[i] - nums[0];
            if (k == 0 || k % 2 != 0) {
                continue;
            }
            k /= 2;
            boolean flag = true;
            boolean[] visited = new boolean[n];
            int[] res = new int[n / 2];
            int l = 0;
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    while (l < n && (visited[l] || nums[j] + 2 * k > nums[l])) {
                        l++;
                    }
                    if (l == n || nums[j] + 2 * k != nums[l]) {
                        flag = false;
                        break;
                    }
                    visited[l] = true;
                    res[index] = nums[j] + k;
                    index++;
                }
            }
            if (flag) {
                return res;
            }
        }
        return null;
    }
}
