class Solution {
    public int removeDuplicates(int[] nums) {
        int counter = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                counter++;
            } else {
                nums[i - counter] = nums[i];
            }
        }
        return nums.length - counter;
    }
}
