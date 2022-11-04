import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int s = res.size();
            for (int j = s - 1; j >= 0; j--) {
                res.add(res.get(j) + (1 << i));
            }
        }
        return res;
    }
}
