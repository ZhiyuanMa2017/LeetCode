import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> ambiguousCoordinates(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n - 2; i++) {
            List<String> A = f(s.substring(1, i + 1));
            List<String> B = f(s.substring(i + 1, n - 1));
            for (String a : A) {
                for (String b : B) {
                    res.add("(" + a + ", " + b + ")");
                }
            }
        }
        return res;
    }

    private List<String> f(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        if (n == 0 || (n > 1 && s.charAt(0) == '0' && s.charAt(n - 1) == '0')) {
            return res;
        }
        if (n > 1 && s.charAt(0) == '0') {
            res.add("0." + s.substring(1));
            return res;
        }
        res.add(s);
        if (n == 1 || s.charAt(n - 1) == '0') {
            return res;
        }
        for (int i = 1; i < n; i++) {
            res.add(s.substring(0, i) + '.' + s.substring(i));
        }
        return res;
    }
}
