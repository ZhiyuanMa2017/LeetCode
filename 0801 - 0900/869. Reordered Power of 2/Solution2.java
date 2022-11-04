import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<Integer> powers = new HashSet<>();

    static {
        for (int i = 1; i < (int) 1e9 + 1; i *= 2) {
            powers.add(i);
        }
    }

    public boolean reorderedPowerOf2(int n) {
        int[] counts = new int[10];
        while (n > 0) {
            counts[n % 10]++;
            n /= 10;
        }
        for (Integer power : powers) {
            if (check(power, counts)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(int power, int[] counts) {
        int[] buckets = new int[10];
        while (power > 0) {
            buckets[power % 10]++;
            power /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (buckets[i] != counts[i]) {
                return false;
            }
        }
        return true;
    }
}
