class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) == 1) {
                    count[i]++;
                }
            }
        }
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < 32; i++) {
            res += count[i] * (n - count[i]);
        }
        return res;
    }
}
