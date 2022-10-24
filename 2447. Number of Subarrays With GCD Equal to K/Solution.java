class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = 0;
            for (int j = i; j < nums.length; j++) {
                c = gcd(c, nums[j]);
                if (c < k || c % k != 0) {
                    break;
                }
                if (c == k) {
                    res++;
                }
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
