class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(cal(nums1, nums2), cal(nums2, nums1));
    }

    private int cal(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int cur = 0;
        int res = 0;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            int diff = nums1[i] - nums2[i];
            cur += diff;
            res = Math.max(res, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return res + sum2;
    }
}
