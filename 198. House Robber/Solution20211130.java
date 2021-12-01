class Solution20211130 {
    public int rob(int[] nums) {
        int rob = 0;
        int noRob = 0;
        for (int num : nums) {
            int newRob = noRob + num;
            noRob = Math.max(noRob, rob);
            rob = newRob;
        }
        return Math.max(rob, noRob);
    }
}
