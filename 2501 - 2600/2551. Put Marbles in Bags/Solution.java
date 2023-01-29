import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            list.add(weights[i] + weights[i + 1]);
        }
        Collections.sort(list);
        long res = 0;
        for (int i = 0; i < k - 1; i++) {
            res += list.get(n - 2 - i) - list.get(i);
        }
        return res;
    }
}
