class Solution {
    public int minimizeArrayValue(int[] nums) {
        int l = 0;
        int h = (int) 1e9;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (check(nums, mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int mid) {
        long extra = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            long cur = nums[i] + extra;
            if (cur <= mid) {
                extra = 0;
            } else {
                extra = cur - mid;
            }
        }
        return extra + nums[0] <= mid;
    }
}
