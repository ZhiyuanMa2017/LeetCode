class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int countZero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
            } else {
                countZero++;
            }
        }
        int productAll = 0;
        if (countZero > 1) {
            product = 0;
        } else if (countZero == 0) {
            productAll = product;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = product;
            } else {
                nums[i] = productAll / nums[i];
            }
        }
        return nums;
    }
}
