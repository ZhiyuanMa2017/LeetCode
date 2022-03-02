import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += (i % 2 == 0 ? nums[i] : 0);
        }
        return res;
    }
}
