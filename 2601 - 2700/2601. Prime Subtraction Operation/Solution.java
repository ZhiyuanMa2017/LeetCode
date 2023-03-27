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

    public boolean primeSubOperation(int[] nums) {
        int prev = 0;
        for (int num : nums) {
            if (num <= prev) {
                return false;
            }
            int cut = binarySearch(num - prev);
            prev = num - cut;
        }
        return true;
    }

    private int binarySearch(int diff) {
        if (diff <= 2) {
            return 0;
        }
        int l = 0;
        int r = PRIMES.size() - 1;
        // nums[mid] < diff
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (PRIMES.get(mid) >= diff) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return PRIMES.get(l);
    }
}
