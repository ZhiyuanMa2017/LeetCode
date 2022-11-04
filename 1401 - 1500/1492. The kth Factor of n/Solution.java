class Solution {
    public int kthFactor(int n, int k) {
        float root = (float) Math.sqrt(n);
        for (int i = 1; i < root; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }
        for (int i = (int) root; i >= 1; i--) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return n / i;
                }
            }
        }
        return -1;
    }
}