class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1;
        int prefixRemain = 0;
        int res = 0;
        for (int num : nums) {
            prefixRemain = (prefixRemain + num % k + k) % k;
            res += count[prefixRemain];
            count[prefixRemain]++;
        }
        return res;
    }
}
