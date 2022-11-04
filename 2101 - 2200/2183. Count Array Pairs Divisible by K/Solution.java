import java.util.ArrayList;
import java.util.List;

class Solution {
    public long coutPairs(int[] nums, int k) {
        long res = 0;
        List<Integer> kFactor = new ArrayList<>();
        for (int i = 1; i * i <= k; i++) {
            if (k % i == 0) {
                kFactor.add(i);
                if (i * i < k) {
                    kFactor.add(k / i);
                }
            }
        }
        long[] count = new long[100001];
        for (int num : nums) {
            res += count[k / gcd(k, num)];
            for (Integer factor : kFactor) {
                if (num % factor == 0) {
                    count[factor]++;
                }
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
