import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        List<Long> res = new ArrayList<>();
        for (int query : queries) {
            long cur = 0;
            int l = 0;
            int r = n;
            // nums[mid] >= query
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] >= query) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (l == n) {
                cur += (long) n * query - preSum[n];
            } else {
                cur += (long) l * query - preSum[l];
                cur += preSum[n] - preSum[l] - (long) (n - l) * query;
            }
            res.add(cur);
        }
        return res;
    }
}
