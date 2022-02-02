import java.util.Arrays;

class Solution {
    public int sumSubseqWidths(int[] nums) {
        long res = 0;
        int mod = 1000000007;
        Arrays.sort(nums);
        int two = 1;
        for (int i = 0; i < nums.length; i++) {
            res = (res + (long) two * nums[i]) % mod;
            two = two * 2 % mod;
        }
        two = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res = (res - (long) two * nums[i] + mod) % mod;
            two = two * 2 % mod;
        }
        return (int) (res + mod) % mod;
    }
}
