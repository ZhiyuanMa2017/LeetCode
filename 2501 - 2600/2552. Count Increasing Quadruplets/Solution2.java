class Solution {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        long[] triplet = new long[n]; // 132 triplet, index is 3
        long res = 0;
        for (int r = 0; r < n; r++) {
            int cur = 0;
            for (int j = 0; j < r; j++) {
                if (nums[j] < nums[r]) {
                    res += triplet[j]; // 1324, r at 4, so res += previous # of 132
                    cur++; // count # of 1 in 132 in this round, here 2 is r and 1 is j
                    // actually count # of 12 in this round
                } else {
                    triplet[j] += cur; // 132, cur is # of 1 in this round,
                    // now find a 3, so triplet[3] += #of 1
                    // 1 3 2
                    //   j r
                }
            }
        }
        return res;
    }
}
