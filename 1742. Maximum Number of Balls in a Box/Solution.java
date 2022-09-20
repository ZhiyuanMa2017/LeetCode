class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[46];
        int res = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = cal(i);
            count[sum]++;
            res = Math.max(res, count[sum]);
        }
        return res;
    }

    private int cal(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
