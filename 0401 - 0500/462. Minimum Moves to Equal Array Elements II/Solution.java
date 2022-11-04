import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int res = 0;
        while (i < j) {
            res += nums[j] - nums[i];
            i++;
            j--;
        }
        return res;
    }
}
