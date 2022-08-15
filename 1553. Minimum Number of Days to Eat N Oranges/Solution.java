import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> dp = new HashMap<>();

    public int minDays(int n) {
        if (n <= 1) {
            return 1;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        dp.put(n, 1 + Math.min(n % 2 + minDays(n / 2), n % 3 + minDays(n / 3)));
        return dp.get(n);
    }
}
