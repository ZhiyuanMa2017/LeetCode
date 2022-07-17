class Solution {
    public int maximumSum(int[] nums) {
        int[] max1 = new int[82];
        int[] max2 = new int[82];
        for (int num : nums) {
            int digit = toDigit(num);
            if (num > max1[digit]) {
                max2[digit] = max1[digit];
                max1[digit] = num;
            } else if (num > max2[digit]) {
                max2[digit] = num;
            }
        }
        int res = -1;
        for (int i = 0; i < 82; i++) {
            if (max2[i] > 0) {
                res = Math.max(res, max1[i] + max2[i]);
            }
        }
        return res;
    }

    private int toDigit(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
