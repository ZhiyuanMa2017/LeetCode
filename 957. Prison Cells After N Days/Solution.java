import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int mask = 0;
        for (int i = 0; i < cells.length; i++) {
            mask |= cells[i] << (cells.length - i - 1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        while (n > 0) {
            map.put(mask, n);
            n--;
            mask = next(mask);
            if (map.containsKey(mask)) {
                n = n % (map.get(mask) - n);
            }
        }
        int[] res = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            res[i] = mask >> (cells.length - i - 1) & 1;
        }
        return res;
    }

    private int next(int mask) {
        mask = ~(mask << 1) ^ (mask >> 1);
        mask &= 0x7e;
        return mask;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7);
    }
}
