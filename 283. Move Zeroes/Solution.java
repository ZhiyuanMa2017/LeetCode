class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i] = num;
                i++;
            }
        }
        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
