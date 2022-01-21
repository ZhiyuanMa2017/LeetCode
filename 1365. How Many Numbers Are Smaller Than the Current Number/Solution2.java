class Solution2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] bucket = new int[101];
        for (int num : nums) {
            bucket[num]++;
        }
        for (int i = 1; i <= 100; i++) {
            bucket[i] += bucket[i - 1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = (nums[i] == 0 ? 0 : bucket[nums[i] - 1]);
        }
        return res;
    }
}
