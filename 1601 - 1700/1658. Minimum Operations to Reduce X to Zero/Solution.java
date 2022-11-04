import java.util.HashMap;

class Solution {
    public int minOperations(int[] nums, int x) {
        int allsum = 0;
        for (int num : nums) {
            allsum += num;
        }
        int middlesum = allsum - x;
        if (middlesum == 0) {
            return nums.length;
        }
        if (middlesum < 0) {
            return -1;
        }
        int sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (mp.containsKey(sum - middlesum)) {
                res = Math.max(res, i - mp.get(sum - middlesum));
            }
            mp.put(sum, i);
        }
        if (res == -1) {
            return -1;
        } else {
            return nums.length - res;
        }
    }
}
