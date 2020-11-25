class Solution {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        int r = 0;
        for (int len = 1; len <= K; len++) {
            r = r * 10 + 1;
            r = r % K;
            if (r == 0) {
                return len;
            }
        }
        return -1;
    }
}