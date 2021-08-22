class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        int p = n - 1;
        int[] res = new int[n];
        while (l <= h) {
            if (Math.abs(nums[l]) >= Math.abs(nums[h])) {
                res[p] = nums[l] * nums[l];
                l++;
                p--;
            } else {
                res[p] = nums[h] * nums[h];
                h--;
                p--;
            }
        }
        return res;
    }
}
