class Solution {
    public int[] singleNumber(int[] nums) {
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        int k = -1;
        for (int i = 0; i < 31; i++) {
            if (((xorSum >> i) & 1) == 1) {
                k = i;
                break;
            }
        }
        int[] res = new int[]{0, 0};
        for (int num : nums) {
            if (((num >> k) & 1) == 1) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
