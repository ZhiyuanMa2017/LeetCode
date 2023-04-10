import java.util.Arrays;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = (int) 1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            int i = 0;
            while (i + 1 < n && count < p) {
                if (nums[i + 1] - nums[i] <= mid) {
                    count++;
                    i += 2;
                } else {
                    i++;
                }
            }
            if (count >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
