class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i : nums) {
            int id = Math.abs(i) - 1;
            if (nums[id] > 0) {
                nums[id] *= -1;
            } else {
                res[0] = id + 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                res[1] = i + 1;
            }
        }
        return res;
    }
}