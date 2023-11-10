class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int res = 0;
        while (l < r) {
            if (nums[l] == nums[r]) {
                l++;
                r--;
            } else if (nums[l] > nums[r]) {
                nums[r - 1] += nums[r];
                res++;
                r--;
            } else {
                nums[l + 1] += nums[l];
                l++;
                res++;
            }
        }
        return res;
    }
}
