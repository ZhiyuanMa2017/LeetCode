import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int zeros = 0;
        int ones = 0;
        for (int num : nums) {
            if (num == 1) {
                ones++;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int max = zeros + ones;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                ones--;
            }
            int cur = zeros + ones;
            if (cur == max) {
                res.add(i + 1);
            }
            if (cur > max) {
                max = cur;
                res.clear();
                res.add(i + 1);
            }
        }
        return res;
    }
}
