class Solution {
    public int differenceOfSum(int[] nums) {
        int e = 0;
        int d = 0;
        for (int num : nums) {
            e += num;
            int cur = num;
            while (cur > 0) {
                d += cur % 10;
                cur /= 10;
            }
        }
        return Math.abs(e - d);
    }
}
