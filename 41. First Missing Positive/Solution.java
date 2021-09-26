class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            while (value - 1 >= 0 && value - 1 < nums.length && value != nums[value - 1]) {
                int tmp = nums[value - 1];
                nums[value - 1] = value;
                value = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
