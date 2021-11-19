class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = leftProduct;
            leftProduct *= nums[i];
        }
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return res;
    }
}
