import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (calDigit(h) + calDigit(m) == turnedOn) {
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return res;
    }

    private int calDigit(int i) {
        int res = 0;
        while (i > 0) {
            res += i & 1;
            i >>= 1;
        }
        return res;
    }
}
