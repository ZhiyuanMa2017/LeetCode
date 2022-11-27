import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] smaller = new int[n];
        int[] bigger = new int[n];
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < k) {
                smaller[i] = 1;
            } else if (nums[i] > k) {
                bigger[i] = 1;
            }
            if (nums[i] == k) {
                index = i;
            }
        }
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = bigger[i] - smaller[i];
        }
        int a = subarraySum(0, n, diff, 0);
        int b = subarraySum(0, index, diff, 0);
        int c = subarraySum(index + 1, n, diff, 0);
        int d = subarraySum(0, n, diff, 1);
        int e = subarraySum(0, index, diff, 1);
        int f = subarraySum(index + 1, n, diff, 1);
        return a - b - c + d - e - f;
    }

    public int subarraySum(int start, int end, int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
            res += preSum.getOrDefault(sum - k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
