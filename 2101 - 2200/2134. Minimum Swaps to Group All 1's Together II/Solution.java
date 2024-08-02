class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) {
            if (num == 1) {
                total++;
            }
        }
        int cur = 0;
        int right = 0;
        while (right < total) {
            if (nums[right] == 1) {
                cur++;
            }
            right++;
        }
        right = right % n;
        int res = total - cur;
        for (int left = 0; left < n; left++) {
            if (nums[left] == 1) {
                cur--;
            }
            if (nums[right] == 1) {
                cur++;
            }
            res = Math.min(res, total - cur);
            right = (right + 1) % n;
        }
        return res;
    }
}
