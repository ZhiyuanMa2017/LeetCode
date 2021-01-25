class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (pre == -1) {
                    pre = i;
                } else {
                    if (i - pre - 1 < k) {
                        return false;
                    }
                    pre = i;
                }
            }
        }
        return true;
    }
}
