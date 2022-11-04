class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] bucket = new int[101];
        for (int num : nums) {
            bucket[num]++;
        }
        int left = 0;
        for (int i = 0; i < 101; i++) {
            left += bucket[i] % 2;
        }
        return new int[]{(nums.length - left) / 2, left};
    }
}
