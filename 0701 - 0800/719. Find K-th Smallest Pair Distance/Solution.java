import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = (int) 1e6;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(nums, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean check(int[] nums, int k, int mid) {
        int n = nums.length;
        int left = 0;
        int right = 1;
        int res = 0;
        while (right < n) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            res += right - left;
            right++;
        }
        return res >= k;
    }
}
