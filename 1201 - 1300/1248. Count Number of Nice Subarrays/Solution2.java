import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        List<Integer> left = new ArrayList<>();
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                left.add(cur);
                cur = 0;
            } else {
                cur++;
            }
        }
        cur = 0;
        List<Integer> right = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] % 2 == 1) {
                right.add(cur);
                cur = 0;
            } else {
                cur++;
            }
        }
        Collections.reverse(right);
        int res = 0;
        for (int i = 0; i < left.size(); i++) {
            if (i + k - 1 >= left.size()) {
                break;
            }
            int leftCount = left.get(i);
            int rightCount = right.get(i + k - 1);
            res += (leftCount + 1) * (rightCount + 1);
        }
        return res;
    }
}
