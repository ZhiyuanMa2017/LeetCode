import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        int d = nums[nums.length - 3];
        int e = nums[nums.length - 2];
        int f = nums[nums.length - 1];
        return Math.max(a * b * f, d * e * f);
    }
}
