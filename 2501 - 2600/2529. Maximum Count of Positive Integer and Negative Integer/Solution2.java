class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        if (nums[0] > 0 || nums[n - 1] < 0) {
            return n;
        }
        int l = 0;
        int r = n - 1;
        // find first non-negative
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int neg = l;
        r = n;
        // find first positive
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int pos = n - l;
        return Math.max(neg, pos);
    }
}
