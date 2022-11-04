import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> seen = new HashSet<>();

        while (!seen.contains(n)) {
            seen.add(n);
            n = cal(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int cal(int n) {
        String s = String.valueOf(n);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - '0';
            res += cur * cur;
        }
        return res;
    }
}
