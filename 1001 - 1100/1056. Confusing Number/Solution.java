class Solution {
    public boolean confusingNumber(int n) {
        int cur = n;
        int res = 0;
        while (cur > 0) {
            int d = cur % 10;
            if (d == 2 || d == 3 || d == 4 || d == 5 || d == 7) {
                return false;
            }
            if (d == 6) {
                d = 9;
            } else if (d == 9) {
                d = 6;
            }
            res = res * 10 + d;
            cur /= 10;
        }
        return res != n;
    }
}
