import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int k = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                k = i;
            }
        }
        if (k == -1) {
            Arrays.sort(nums);
            return;
        }
        int l = k + 1;
        for (int i = k + 2; i < nums.length; i++) {
            if (nums[k] < nums[i]) {
                l = i;
            }
        }
        int tmp = nums[k];
        nums[k] = nums[l];
        nums[l] = tmp;
        for (int i = 1; i + k < nums.length - i; i++) {
            tmp = nums[k + i];
            nums[k + i] = nums[nums.length - i];
            nums[nums.length - i] = tmp;
        }
    }
}
