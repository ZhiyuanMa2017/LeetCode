class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int max = nums[0];
        int min = nums[nums.length - 1];
        int start = -1;
        int end = -2;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length - i - 1]);
            if (nums[i] < max) {
                end = i;
            }
            if (nums[nums.length - i - 1] > min) {
                start = nums.length - i - 1;
            }
        }
        return end - start + 1;
    }
}
