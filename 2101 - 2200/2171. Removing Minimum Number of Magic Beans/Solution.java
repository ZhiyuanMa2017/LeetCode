import java.util.Arrays;

class Solution {
    public long minimumRemoval(int[] beans) {
        if (beans.length <= 1) {
            return 0;
        }
        long sum = 0;
        Arrays.sort(beans);
        long max = sum;
        for (int i = 0; i < beans.length; i++) {
            sum += beans[i];
            max = Math.max(max, (beans.length - i) * ((long) beans[i]));
        }
        return sum - max;
    }
}
