class Solution {
    public int wiggleMaxLength(int[] nums) {
        int larger = 1;
        int smaller = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                larger = smaller + 1;
            } else if (nums[i] < nums[i - 1]) {
                smaller = larger + 1;
            }
        }
        return Math.max(smaller, larger);
    }
}
