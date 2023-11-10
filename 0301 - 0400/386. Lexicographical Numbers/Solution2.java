import java.util.ArrayList;
import java.util.List;

class Solution {
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int cur = 1;
        for (int i = 0; i < n; i++) {
            res.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else {
                while (cur % 10 == 9 || cur + 1 > n) {
                    cur /= 10;
                }
                cur++;
            }
        }
        return res;
    }
}
