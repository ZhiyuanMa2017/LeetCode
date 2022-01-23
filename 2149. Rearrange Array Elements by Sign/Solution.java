class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        int j = 1;
        for (int num : nums) {
            if (num > 0) {
                res[i] = num;
                i += 2;
            } else {
                res[j] = num;
                j += 2;
            }
        }
        return res;
    }
}
