import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return res;
        }
        long sum = 0;
        long cur = 2;
        while (sum < finalSum) {
            res.add(cur);
            sum += cur;
            cur += 2;
        }
        if (sum > finalSum) {
            long last = res.remove(res.size() - 1);
            sum -= last;
            long remain = finalSum - sum;
            res.set(res.size() - 1, res.get(res.size() - 1) + remain);
        }
        return res;
    }
}
