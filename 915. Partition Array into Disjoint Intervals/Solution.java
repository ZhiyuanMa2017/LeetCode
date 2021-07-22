class Solution {
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int curMax = leftMax;
        int partition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftMax > nums[i]) {
                leftMax = curMax;
                partition = i;
            } else {
                curMax = Math.max(curMax, nums[i]);
            }
        }
        return partition + 1;
    }
}
