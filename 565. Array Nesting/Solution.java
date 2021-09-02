class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int res = 0;
        boolean[] seen = new boolean[n];
        for (int k : nums) {
            int count = 0;
            while (!seen[k]) {
                count++;
                seen[k] = true;
                k = nums[k];
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
