import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        // 00 01
        // 11 10
        // 00 01 11 10
        // 00   01  11  10  10  11  01  00
        // 000 001 011 010 110 111 101 100
        for (int i = 0; i < n; i++) {
            int s = res.size();
            for (int j = s - 1; j >= 0; j--) {
                res.add(res.get(j) + (1 << i));
            }
        }
        return res;
    }
}
