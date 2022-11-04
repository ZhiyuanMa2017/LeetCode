class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int cur = n;
        int len = 0;
        while (cur > 0) {
            cur >>= 1;
            len++;
        }
        int i = 1;
        while (len > 0) {
            n = n ^ i;
            i <<= 1;
            len--;
        }
        return n;
    }
}
