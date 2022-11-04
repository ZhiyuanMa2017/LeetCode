import java.util.Arrays;

class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int res = 0;
        while (amount[0] != 0 || amount[1] != 0 || amount[2] != 0) {
            if (amount[0] > 0) {
                res++;
                amount[0]--;
                amount[2]--;
            } else if (amount[1] > 0) {
                res++;
                amount[1]--;
                amount[2]--;
            } else {
                res += amount[2];
                amount[2] = 0;
            }
            Arrays.sort(amount);
        }
        return res;
    }
}
