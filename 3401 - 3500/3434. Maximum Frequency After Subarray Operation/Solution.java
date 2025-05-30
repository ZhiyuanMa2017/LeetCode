import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        int kCount = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num == k) {
                kCount++;
            }
            set.add(num);
        }
        int res = 0;
        for (Integer num : set) {
            int cur = cal(nums, num, k);
            res = Math.max(res, cur);
        }
        return res + kCount;
    }

    private int cal(int[] nums, int use, int k) {
        int countK = 0;
        int countUse = 0;
        int l = 0;
        int res = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == use) {
                countUse++;
            }
            if (nums[r] == k) {
                countK++;
            }
            while (l <= r && countK > countUse) {
                if (nums[l] == use) {
                    countUse--;
                }
                if (nums[l] == k) {
                    countK--;
                }
                l++;
            }
            res = Math.max(res, countUse - countK);
        }
        return res;
    }
}
