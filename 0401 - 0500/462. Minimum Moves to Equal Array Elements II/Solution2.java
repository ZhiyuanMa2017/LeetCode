import java.util.Arrays;

class Solution2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int median = nums[(nums.length - 1) / 2];
        for (int num : nums) {
            res += Math.abs(num - median);
        }
        return res;
    }
}
