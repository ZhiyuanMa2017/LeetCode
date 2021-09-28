import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int next = lower;
        for (int num : nums) {
            if (num < next) {
                continue;
            } else if (num == next) {
                next++;
            } else {
                res.add(getS(next, num - 1));
                next = num + 1;
            }
        }
        if (next <= upper) {
            res.add(getS(next, upper));
        }
        return res;
    }

    private String getS(int from, int to) {
        if (from == to) {
            return String.valueOf(from);
        }
        return from + "->" + to;
    }
}
