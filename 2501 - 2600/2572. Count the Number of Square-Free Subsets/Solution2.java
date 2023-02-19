import java.util.HashMap;
import java.util.Map;

class Solution {
    public int squareFreeSubsets(int[] nums) {
        int mod = (int) (1e9 + 7);
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (num % 4 == 0 || num % 9 == 0 || num % 25 == 0) {
                continue;
            }
            counter.merge(num, 1, Integer::sum);
        }
        Map<Long, Long> map = new HashMap<>() {{
            put(1L, 1L);
        }};
        for (Integer v : counter.keySet()) {
            if (v != 1) {
                Map<Long, Long> curMap = new HashMap<>();
                for (Long v1 : map.keySet()) {
                    curMap.merge(v1, map.get(v1), Long::sum);
                    if (gcd(v, v1) == 1) {
                        curMap.merge(v1 * v, map.get(v1) * counter.get(v), Long::sum);
                    }
                    curMap.put(v1, curMap.get(v1) % mod);
                }
                map = curMap;
            }
        }
        long res = 0;
        for (Long value : map.values()) {
            res = (res + value) % mod;
        }
        int pow = 1;
        for (int i = 0; i < counter.getOrDefault(1, 0); i++) {
            pow = (pow * 2) % mod;
        }
        res = (res * pow - 1) % mod;
        return (int) res;
    }

    private long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
