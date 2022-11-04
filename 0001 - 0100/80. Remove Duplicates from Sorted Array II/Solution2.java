class Solution2 {
    public int removeDuplicates(int[] nums) {
        return removeDuplicates(nums, 2);
    }

    private int removeDuplicates(int[] nums, int k) {
        int i, j;
        for (i = k, j = k; i < nums.length; i++) {
            if (nums[j - k] != nums[i]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
