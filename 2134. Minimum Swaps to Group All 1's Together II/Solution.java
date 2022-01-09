class Solution {
    public int minSwaps(int[] nums) {
        int all = 0;
        for (int num : nums) {
            if (num == 1) {
                all++;
            }
        }
        int res = Integer.MAX_VALUE;
        int cur = 0;
        for (int i = 0; i < all; i++) {
            if (nums[i] == 1) {
                cur++;
            }
        }
        res = Math.min(res, all - cur);
        if (res == 0) {
            return 0;
        }
        for (int i = 1; i + all < nums.length * 2; i++) {
            int l = i;
            int r = i + all;
            int left = (l - 1) % nums.length;
            int right = (r - 1) % nums.length;
            if (nums[left] == 1) {
                cur -= 1;
            }
            if (nums[right] == 1) {
                cur += 1;
            }
            res = Math.min(res, all - cur);
        }

        return res;

    }
}
