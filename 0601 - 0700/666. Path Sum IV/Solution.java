class Solution {
    public int pathSum(int[] nums) {
        int[][] tree = new int[7][33];
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int d = num / 100;
            int p = num / 10 % 10;
            int v = num % 10;
            tree[d][p] = tree[d + 1][p * 2 - 1] + tree[d + 1][p * 2];
            if (tree[d][p] == 0) {
                tree[d][p] = 1;
            }
            res += v * tree[d][p];
        }
        return res;
    }
}
