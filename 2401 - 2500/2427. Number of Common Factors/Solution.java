class Solution {
    public int commonFactors(int a, int b) {
        int res = 1;
        int max = gcd(a, b);
        for (int i = 2; i <= max; i++) {
            if (a % i == 0 && b % i == 0) {
                res++;
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
