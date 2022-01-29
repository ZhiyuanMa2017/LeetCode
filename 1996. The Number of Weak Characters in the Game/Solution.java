import java.util.Arrays;

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        int res = 0;
        // 0 down, 1 up
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < properties.length; i++) {
            if (max > properties[i][1]) {
                res++;
            }
            max = Math.max(max, properties[i][1]);

        }
        return res;
    }
}
