class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return true;
        }
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                if (flag) {
                    return false;
                } else {
                    flag = true;
                    if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                        nums[i] = nums[i - 1];
                    }
                }
            }
        }
        return true;
    }
}
