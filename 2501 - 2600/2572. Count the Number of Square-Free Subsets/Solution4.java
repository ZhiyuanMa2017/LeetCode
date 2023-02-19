import java.util.HashMap;
import java.util.Map;

class Solution {
    public int squareFreeSubsets(int[] nums) {
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int mod = (int) (1e9 + 7);
        Map<Integer, Long> maskToCount = new HashMap<>();
        for (int num : nums) {
            if (num % 4 == 0 || num % 9 == 0 || num % 25 == 0) {
                continue;
            }
            int mask = 0;
            for (int i = 0; i < primes.length; i++) {
                if (num % primes[i] == 0) {
                    mask |= 1 << i;
                }
            }
            Map<Integer, Long> additional = new HashMap<>();
            for (Integer m : maskToCount.keySet()) {
                if ((mask & m) == 0) {
                    additional.put(mask | m, maskToCount.get(m) % mod);
                }
            }
            for (Integer k : additional.keySet()) {
                maskToCount.merge(k, additional.get(k), Long::sum);
                maskToCount.put(k, maskToCount.get(k) % mod);
            }
            maskToCount.merge(mask, 1L, Long::sum);
            maskToCount.put(mask, maskToCount.get(mask) % mod);
        }
        long res = 0;
        for (Long value : maskToCount.values()) {
            res = (res + value) % mod;
        }
        return (int) res;
    }
}
