import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int len1 = String.valueOf(low).length();
        int len2 = String.valueOf(high).length();
        List<Integer> res = new ArrayList<>();
        for (int len = len1; len <= len2; len++) {
            for (int i = 1; i + len <= 9; i++) {
                int cur = 0;
                for (int j = i; j < i + len; j++) {
                    cur = cur * 10 + j;
                }
                if (cur >= low && cur <= high) {
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
