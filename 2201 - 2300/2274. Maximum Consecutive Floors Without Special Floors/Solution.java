import java.util.Arrays;

class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int res = 0;
        for (int i = 0; i < special.length; i++) {
            if (i == 0) {
                res = Math.max(special[i] - bottom, res);
            } else {
                res = Math.max(res, special[i] - special[i - 1] - 1);
            }
        }
        res = Math.max(res, top - special[special.length - 1]);
        return res;
    }
}
