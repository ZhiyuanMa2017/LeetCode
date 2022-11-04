import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int res = 0;
        int cur = 0;
        int index = satisfaction.length - 1;
        while (index >= 0 && cur + satisfaction[index] > 0) {
            cur += satisfaction[index];
            res += cur;
            index--;
        }
        return res;
    }
}
