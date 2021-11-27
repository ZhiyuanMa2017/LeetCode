class Solution20211126 {
    public int[] productExceptSelf(int[] nums) {
        int k = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k *= nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }
        return res;
    }
}
