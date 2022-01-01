class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        int index = 1;
        for (int num : nums) {
            arr[index] = num;
            index++;
        }
        arr[index] = 1;
        int[][] memo = new int[n + 2][n + 2];
        return burst(arr, memo, 0, n + 1);
    }

    private int burst(int[] arr, int[][] memo, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }
        if (memo[left][right] > 0) {
            return memo[left][right];
        }
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res,
                    arr[left] * arr[i] * arr[right] + burst(arr, memo, left, i) + burst(arr, memo, i, right));
        }
        memo[left][right] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxCoins(new int[]{3, 1, 5, 8});
    }
}
