class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j;
        for (j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[i] == 0) {
                    k++;
                }
                i++;
            }
        }
        return j - i;
    }
}
