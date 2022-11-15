class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int[] bucket = new int[1001];
        for (int num : nums) {
            bucket[num]++;
        }
        int res = -1;
        int i = 1;
        int j = 1000;
        while (i <= j) {
            if (bucket[j] == 0 || i + j >= k) {
                j--;
            } else {
                if (bucket[i] >= (i == j ? 2 : 1)) {
                    res = Math.max(res, i + j);
                }
                i++;
            }
        }
        return res;
    }
}
