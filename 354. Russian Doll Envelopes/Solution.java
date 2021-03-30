import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[0] == a2[0] ? a2[1] - a1[1] : a1[0] - a2[0];
            }
        });

        int[] tails = new int[envelopes.length];
        int size = 0;
        for (int[] envelope : envelopes) {
            int i = 0, j = size;
            while (i != j) {
                int m = i + (j - i) / 2;
                if (tails[m] < envelope[1]) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = envelope[1];
            if (i == size) {
                size++;
            }
        }
        return size;
    }
}
