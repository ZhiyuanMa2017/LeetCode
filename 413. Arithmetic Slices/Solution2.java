class Solution2 {
    public int numberOfArithmeticSlices(int[] nums) {
        int diff = 0;
        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (diff == nums[i + 1] - nums[i]) {
                count++;
            } else {
                if (count >= 2) {
                    int len = count + 1 - 3 + 1;
                    res += len * (len + 1) / 2;
                }
                count = 1;
                diff = nums[i + 1] - nums[i];
            }
        }
        if (count >= 2) {
            System.out.println(count);
            int len = count + 1 - 3 + 1;
            res += len * (len + 1) / 2;
        }
        return res;
    }
}
