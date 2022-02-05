import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> l = new ArrayList<>();
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                l.add(count);
                count = 0;
            } else {
                count++;
            }
        }
        l.add(count);
        int res = 0;
        for (int i = 0; i + k < l.size(); i++) {
            int first = l.get(i);
            int last = l.get(i + k);
            res += (first + 1) * (last + 1);
        }
        return res;
    }
}
