import java.util.Arrays;

class Solution {
    public int minimumDeletions(int[] nums) {
        int hindex = 0;
        int lindex = 0;
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[hindex]) {
                hindex = i;
            }
            if (nums[i] < nums[lindex]) {
                lindex = i;
            }
        }
        int large = Math.max(hindex, lindex);
        int small = Math.min(hindex, lindex);
        int front = small + 1;
        int between = large - small;
        int back = n - large;
        int[] temp = new int[]{front, between, back};
        Arrays.sort(temp);
        return temp[0] + temp[1];
    }
}
