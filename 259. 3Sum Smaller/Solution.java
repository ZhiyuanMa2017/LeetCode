import java.util.Arrays;

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            res += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return res;
    }

    private int twoSumSmaller(int[] nums, int start, int target) {
        int res = 0;
        int l = start;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] < target) {
                res += r - l;
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
