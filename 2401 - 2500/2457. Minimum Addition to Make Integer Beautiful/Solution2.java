class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long num = n;
        long base = 1;
        while (digitSum(num) > target) {
            num = num / 10 + 1;
            base *= 10;
        }
        return num * base - n;
    }

    private int digitSum(long n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}
