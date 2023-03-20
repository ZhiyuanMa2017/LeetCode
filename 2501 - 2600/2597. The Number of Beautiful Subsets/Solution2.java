import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int[] POWS = new int[21];

    static {
        POWS[0] = 1;
        for (int i = 1; i < 21; i++) {
            POWS[i] = 2 * POWS[i - 1];
        }
    }

    public int beautifulSubsets(int[] nums, int k) {
        int res = 1;
        int[] count = new int[1010];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i <= 1000; i++) {
            int v = i;
            if (v > k && count[v - k] > 0) {
                continue;
            }
            if (count[v] == 0) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            while (v <= 1000 && count[v] > 0) {
                list.add(count[v]);
                v += k;
            }
            res *= dp(list);
        }
        return res - 1;
    }

    private int dp(List<Integer> list) {
        int choose = 0;
        int notChoose = 1;
        for (Integer num : list) {
            int curChoose = notChoose * (POWS[num] - 1);
            int curNotChoose = choose + notChoose;
            choose = curChoose;
            notChoose = curNotChoose;
        }
        return choose + notChoose;
    }
}
