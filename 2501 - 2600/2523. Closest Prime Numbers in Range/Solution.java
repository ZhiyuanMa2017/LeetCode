import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final List<Integer> PRIMES = new ArrayList<>();

    static {
        boolean[] notP = new boolean[1000000 + 1];
        for (int i = 2; i <= 1000000; i++) {
            if (notP[i]) {
                continue;
            }
            PRIMES.add(i);
            for (int j = 1; j * i <= 1000000; j++) {
                notP[j * i] = true;
            }
        }
    }

    public int[] closestPrimes(int left, int right) {
        int i = 0;
        while (i < PRIMES.size() && PRIMES.get(i) < left) {
            i++;
        }
        int j = PRIMES.size() - 1;
        while (j >= 0 && PRIMES.get(j) > right) {
            j--;
        }
        int nums1 = -1;
        int nums2 = -1;
        int len = Integer.MAX_VALUE;
        for (; i < j; i++) {
            int p1 = PRIMES.get(i);
            int p2 = PRIMES.get(i + 1);
            if (p2 - p1 < len) {
                len = p2 - p1;
                nums2 = p2;
                nums1 = p1;
            }
        }
        return new int[]{nums1, nums2};
    }
}
