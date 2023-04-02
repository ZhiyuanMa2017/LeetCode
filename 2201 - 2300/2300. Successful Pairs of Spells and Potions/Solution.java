import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int l = 0;
            int r = m;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if ((long) potions[mid] * spell >= success) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            res[i] = m - l;
        }
        return res;
    }
}
