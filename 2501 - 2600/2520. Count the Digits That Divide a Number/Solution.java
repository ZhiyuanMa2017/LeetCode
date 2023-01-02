class Solution {
    public int countDigits(int num) {
        int res = 0;
        int cur = num;
        while (cur > 0) {
            int digit = cur % 10;
            if (num % digit == 0) {
                res++;
            }
            cur /= 10;
        }
        return res;
    }
}
