class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int res = n + 1;
        int left = 0;
        int right = 0;
        int[] count = new int[32];
        int cur = 0;
        while (right < n) {
            for (int i = 0; i < 32; i++) {
                if ((nums[right] >> i & 1) == 1) {
                    count[i]++;
                    if (count[i] == 1) {
                        cur += 1 << i;
                    }

                }
            }
            while (cur >= k && left < right) {
                res = Math.min(res, right - left + 1);
                for (int i = 0; i < 32; i++) {
                    if ((nums[left] >> i & 1) == 1) {
                        count[i]--;
                        if (count[i] == 0) {
                            cur -= 1 << i;
                        }
                    }
                }
                left++;
            }
            right++;
        }
        return res == n + 1 ? -1 : res;
    }
}
