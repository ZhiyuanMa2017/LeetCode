class Solution {
    public int minOperations(int[] nums, int x) {
        int res = -1;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int left = 0;
        int right = 0;
        int cur = 0;
        while (right < nums.length) {
            cur += nums[right];
            while (cur > total - x && left <= right) {
                cur -= nums[left];
                left++;
            }
            if (cur == total - x) {
                res = Math.max(res, right - left + 1);
            }
            right++;
        }
        if (res == -1) {
            return -1;
        } else {
            return nums.length - res;
        }
    }
}
