class Solution {
    public boolean isPossible(int[] nums) {
        int n = nums.length;
        int dp1 = 0;
        int dp2 = 0;
        int dp3 = 0;
        int i = 0;
        while (i < n) {
            int num = nums[i];
            int j = i;
            while (i < n && nums[i] == nums[j]) {
                i++;
            }
            int count = i - j;
            if (j > 0 && num != nums[j - 1] + 1) {
                if (dp1 + dp2 > 0) {
                    return false;
                } else {
                    dp1 = count;
                    dp2 = 0;
                    dp3 = 0;
                }
            } else {
                if (dp1 + dp2 > count) {
                    return false;
                } else {
                    int left = count - dp1 - dp2;
                    int use = Math.min(dp3, left);
                    dp3 = dp2 + use;
                    dp2 = dp1;
                    dp1 = left - use;
                }
            }
        }
        return dp1 == 0 && dp2 == 0;
    }
}
