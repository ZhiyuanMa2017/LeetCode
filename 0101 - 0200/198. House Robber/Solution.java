class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int rob = 0;
        int noRob = 0;
        for (int num : nums) {
            int thisRob = noRob + num;
            noRob = Math.max(rob, noRob);
            rob = thisRob;
        }
        return Math.max(rob, noRob);
    }
}
