class Solution {
    public int[] decompressRLElist(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            length += freq;
        }
        int[] res = new int[length];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            for (int j = 0; j < freq; j++) {
                res[index] = val;
                index++;
            }
        }
        return res;
    }
}
