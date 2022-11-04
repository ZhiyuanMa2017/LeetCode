import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            count++;
            if (i > 0 && count <= nums[i] && count > nums[i - 1]) {
                return count;
            }
            if (i == 0 && count <= nums[i]) {
                return count;
            }
        }
        return -1;
    }
}
