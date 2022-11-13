class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int gcd;
            int lcm = nums[i];
            for (int j = i; j < nums.length; j++) {
                gcd = gcd(lcm, nums[j]);
                lcm = lcm * nums[j] / gcd;
                if (lcm == k) {
                    res++;
                }
                if (lcm > k) {
                    break;
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
