class Solution {
    public int minStartValue(int[] nums) {
        int min = 0;
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            cur += nums[i];
            min = Math.min(cur, min);
        }
        return 1 - min;
    }
}
