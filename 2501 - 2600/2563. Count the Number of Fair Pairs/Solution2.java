import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        long res = 0;
        int j = n - 1;
        int k = n - 1;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            while (j >= 0 && nums[i] + nums[j] >= lower) {
                j--;
            }
            while (k >= 0 && nums[i] + nums[k] > upper) {
                k--;
            }
            res += k - j - (i > j && i <= k ? 1 : 0);
        }
        return res / 2;
    }
}
