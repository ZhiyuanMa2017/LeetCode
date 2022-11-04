class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        int curSum = digitSum(n);
        if (curSum <= target) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int with = 0;
        while (n > 0 && curSum > target) {
            int cur = (int) (n % 10);
            cur += with;
            if (cur == 0) {
                sb.append(0);
            } else {
                int diff = 10 - cur;
                curSum -= cur;
                curSum += 1;
                sb.append(diff);
                with = 1;
            }
            n /= 10;
        }
        return Long.parseLong(sb.reverse().toString());
    }

    private int digitSum(long n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}
