class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] leftN = new int[n + 1]; // not included [i, n]
        int[] rightY = new int[n + 1]; // included [0, i)
        for (int i = 1; i <= n; i++) {
            leftN[i] = leftN[i - 1] + (customers.charAt(i - 1) == 'N' ? 1 : 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            rightY[i] = rightY[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        int min = n;
        int res = 0;
        for (int i = 0; i <= n; i++) {
            int cur = leftN[i] + rightY[i];
            if (cur < min) {
                min = cur;
                res = i;
            }
        }
        return res;
    }
}
