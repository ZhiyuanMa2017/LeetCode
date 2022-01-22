import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countPairs(int[] deliciousness) {
        int mod = 1000000007;
        Map<Integer, Integer> counter = new HashMap<>();
        int res = 0;
        for (int num : deliciousness) {
            int sum = 1;
            for (int i = 0; i < 22; i++) {
                if (sum >= num && counter.containsKey(sum - num)) {
                    res += counter.get(sum - num);
                    res %= mod;
                }
                sum *= 2;
            }
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}
