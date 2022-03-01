class Solution2 {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] + n * (nums[nums[i]] % n);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] / n;
        }
        return nums;
    }
}
