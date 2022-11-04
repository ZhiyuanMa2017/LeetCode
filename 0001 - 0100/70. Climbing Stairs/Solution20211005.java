class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int res = 0;
        int one = 1;
        int two = 2;
        for (int i = 3; i <= n; i++) {
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }
}
