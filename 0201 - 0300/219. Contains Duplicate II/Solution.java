class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (j + i >= nums.length) {
                    break;
                }
                if (nums[i] == nums[j + i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
