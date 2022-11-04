class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        int res = 0;
        for (int i = 1; i < 101; i++) {
            res += (count[i]) * (count[i] - 1) / 2;
        }
        return res;
    }
}
