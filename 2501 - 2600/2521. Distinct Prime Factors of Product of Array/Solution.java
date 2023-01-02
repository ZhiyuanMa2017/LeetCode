import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final List<Integer> PRIMES = new ArrayList<>();

    static {
        boolean[] notP = new boolean[1000 + 1];
        for (int i = 2; i <= 1000; i++) {
            if (notP[i]) {
                continue;
            }
            PRIMES.add(i);
            for (int j = 1; j * i <= 1000; j++) {
                notP[j * i] = true;
            }
        }
    }

    public int distinctPrimeFactors(int[] nums) {
        int res = 0;
        for (Integer prime : PRIMES) {
            boolean used = false;
            for (int num : nums) {
                if (num == 1) {
                    continue;
                }
                if (num < prime) {
                    continue;
                }
                if (num % prime == 0) {
                    used = true;
                    while (num % prime == 0) {
                        num /= prime;
                    }
                }
            }
            if (used) {
                res++;
            }
        }
        return res;
    }
}
