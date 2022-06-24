import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int i = 0;
        int j = 0;
        while (i < slots1.length && j < slots2.length) {
            int start1 = slots1[i][0];
            int end1 = slots1[i][1];
            int start2 = slots2[j][0];
            int end2 = slots2[j][1];
            int start = Math.max(start1, start2);
            int end = Math.min(end1, end2);
            if (end - start >= duration) {
                return List.of(start, start + duration);
            }
            if (end1 < end2) {
                i++;
            } else {
                j++;
            }
        }
        return new ArrayList<>();
    }
}
