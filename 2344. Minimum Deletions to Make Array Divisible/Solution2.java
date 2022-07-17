import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int g = 0;
        for (int i : numsDivide) {
            g = gcd(g, i);
        }
        Arrays.sort(nums);
        int res = 0;
        for (int num : nums) {
            if (g % num != 0) {
                res++;
            } else {
                return res;
            }
        }
        return -1;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
