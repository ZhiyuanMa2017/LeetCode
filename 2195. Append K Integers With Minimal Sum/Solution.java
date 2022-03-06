import java.util.Arrays;

class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long res = 0;
        int pre = 0;
        for (int num : nums) {
            if (k == 0) {
                break;
            }
            int len = num - pre;
            if (len > 1) {
                int jianju = len - 1;
                if (jianju >= k) {
                    jianju = k;
                    k = 0;
                } else {
                    k -= jianju;
                }
                int first = pre + 1;
                int second = pre + jianju;
                res += (long) (first + second) * jianju / 2;
            }
            pre = num;
        }
        if (k > 0) {
            int next = pre + 1;
            int nextnext = pre + k;
            res += (long) (next + nextnext) * k / 2;
        }
        return res;
    }
}
