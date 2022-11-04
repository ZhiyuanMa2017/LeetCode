class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] res = new int[target + 1];
        res[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            for (int num : nums) {
                if (num > i) {
                    continue;
                } else {
                    res[i] += res[i - num];
                }
            }
        }
        return res[target];
    }
}
