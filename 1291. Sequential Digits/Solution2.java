import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<Integer> sequentialDigits(int low, int high) {
        int len1 = String.valueOf(low).length();
        int len2 = String.valueOf(high).length();
        List<Integer> res = new ArrayList<>();
        String sample = "123456789";
        for (int len = len1; len <= len2; len++) {
            for (int i = 0; i + len < 10; i++) {
                int cur = Integer.parseInt(sample.substring(i, i + len));
                if (cur >= low && cur <= high) {
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
