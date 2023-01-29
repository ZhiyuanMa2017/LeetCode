class Solution {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        long[] triplet = new long[n]; // 132 triplet, index is 3
        long res = 0;
        for (int l = 0; l < n; l++) {
            int cur = 0;
            for (int j = 0; j < l; j++) {
                if (nums[l] > nums[j]) {
                    res += triplet[j]; // 1324, l at 4, so res += previous # of 132
                    cur++; // count # of 1 in 132 in this round, here 2 is l and 1 is j
                } else {
                    triplet[j] += cur; // 132, cur is # of 1 in this round,
                                       // now find a 3, so triplet[3] += # of 1
                }
            }
        }
        return res;
    }
}
