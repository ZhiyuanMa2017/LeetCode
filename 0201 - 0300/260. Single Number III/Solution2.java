class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // xor & (-xor) to get the rightmost 1 bit
        int mask = xor & (-xor);
        int a = 0;
        for (int num : nums) {
            if ((num & mask) != 0) {
                a ^= num;
            }
        }
        return new int[]{a, a ^ xor};
    }
}
