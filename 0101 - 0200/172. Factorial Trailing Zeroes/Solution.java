class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = 5; i <= n; i++) {
            int cur = i;
            while (cur % 5 == 0) {
                res++;
                cur /= 5;
            }
        }
        return res;
    }
}
