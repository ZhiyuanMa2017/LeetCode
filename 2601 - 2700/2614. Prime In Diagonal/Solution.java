class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i][i] > res && isPrime(nums[i][i])) {
                res = nums[i][i];
            }
            if (nums[i][n - 1 - i] > res && isPrime(nums[i][n - 1 - i])) {
                res = nums[i][n - 1 - i];
            }
        }
        return res;
    }

    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
