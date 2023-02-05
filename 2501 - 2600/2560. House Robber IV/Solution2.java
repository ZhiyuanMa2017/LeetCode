class Solution {
    public int minCapability(int[] nums, int k) {
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for (int num : nums) {
            l = Math.min(l, num);
            r = Math.max(r, num);
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(mid, nums, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int value, int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= value) {
                count++;
                i++;
            }
        }
        return count >= k;
    }
}
