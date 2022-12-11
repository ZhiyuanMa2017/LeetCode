import java.util.Arrays;

class Solution {
    public int longestSquareStreak(int[] nums) {
        boolean[] bucket = new boolean[100001];
        for (int num : nums) {
            bucket[num] = true;
        }
        int res = -1;
        Arrays.sort(nums);
        for (int num : nums) {
            long cur = num;
            int len = 0;
            while (cur <= 100000 && bucket[(int) cur]) {
                len++;
                bucket[(int) cur] = false;
                cur = cur * cur;
            }
            if (len >= 2) {
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
