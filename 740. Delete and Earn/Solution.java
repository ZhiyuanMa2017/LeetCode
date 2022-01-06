class Solution {
    public int deleteAndEarn(int[] nums) {
        int use = 0;
        int notUse = 0;
        int prev = -1;
        int[] bucket = new int[10001];
        for (int num : nums) {
            bucket[num]++;
        }
        for (int i = 0; i < 10001; i++) {
            if (bucket[i] == 0) {
                continue;
            }
            int curMax = Math.max(use, notUse);
            if (i - 1 == prev) {
                use = i * bucket[i] + notUse;
                notUse = curMax;
            } else {
                use = i * bucket[i] + curMax;
                notUse = curMax;
            }
            prev = i;
        }
        return Math.max(use, notUse);
    }
}
