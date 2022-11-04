class Solution {
    public boolean judgeSquareSum(int c) {
        int l = 0;
        int r = (int) Math.sqrt(c);
        int sum;
        while (l <= r) {
            sum = l * l + r * r;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                l += 1;
            } else {
                r -= 1;
            }
        }
        return false;
    }
}
