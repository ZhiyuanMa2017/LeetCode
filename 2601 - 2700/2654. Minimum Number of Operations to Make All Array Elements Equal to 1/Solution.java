class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        int g = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            }
            g = gcd(g, num);
        }
        if (count > 0) {
            return n - count;
        } else if (g != 1) {
            return -1;
        } else {
            int min = n;
            for (int i = 0; i < n; i++) {
                g = 0;
                for (int j = i; j < n; j++) {
                    g = gcd(g, nums[j]);
                    if (g == 1) {
                        min = Math.min(min, j - i + 1);
                        break;
                    }
                }
            }
            return min - 1 + n - 1;
        }
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
