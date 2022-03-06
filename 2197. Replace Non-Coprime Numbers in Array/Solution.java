import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
            while (res.size() > 1) {
                int one = res.get(res.size() - 1);
                int two = res.get(res.size() - 2);
                int gcd = gcd(one, two);
                if (gcd == 1) {
                    break;
                }
                res.remove(res.size() - 1);
                res.remove(res.size() - 1);
                res.add(one / gcd * two);
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
