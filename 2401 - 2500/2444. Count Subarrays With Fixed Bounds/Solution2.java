class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int p1 = -1;
        int p2 = -1;
        int left = 0;
        long res = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == minK) {
                p1 = right;
            }
            if (nums[right] == maxK) {
                p2 = right;
            }
            if (nums[right] < minK || nums[right] > maxK) {
                left = right + 1;
            }
            res += Math.max(0, Math.min(p1, p2) - left + 1);
        }
        return res;
    }
}
