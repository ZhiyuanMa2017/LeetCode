import java.util.ArrayList;
import java.util.List;

class Solution3 {
    String s1;
    String s2;

    public boolean possiblyEquals(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        return fn(0, 0, 0);
    }

    private boolean fn(int i, int j, int diff) {
        if (i == s1.length() && j == s2.length()) {
            return diff == 0;
        }
        if (i < s1.length() && Character.isDigit(s1.charAt(i))) {
            int ii = i;
            while (ii < s1.length() && Character.isDigit(s1.charAt(ii))) {
                ii += 1;
            }
            for (int x : gg(s1.substring(i, ii))) {
                if (fn(ii, j, diff - x)) {
                    return true;
                }
            }
        } else if (j < s2.length() && Character.isDigit(s2.charAt(j))) {
            int jj = j;
            while (jj < s2.length() && Character.isDigit(s2.charAt(jj))) {
                jj += 1;
            }
            for (int x : gg(s2.substring(j, jj))) {
                if (fn(i, jj, diff + x)) {
                    return true;
                }
            }
        } else if (diff == 0) {
            if (i == s1.length() || j == s2.length() || s1.charAt(i) != s2.charAt(j)) {
                return false;
            }
            return fn(i + 1, j + 1, 0);
        } else if (diff > 0) {
            if (i == s1.length()) {
                return false;
            }
            return fn(i + 1, j, diff - 1);
        } else {
            if (j == s2.length()) {
                return false;
            }
            return fn(i, j + 1, diff + 1);
        }
        return false;
    }

    private List<Integer> gg(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        res.add(Integer.parseInt(s));
        if (n == 2) {
            if (s.charAt(1) != '0') {
                res.add((s.charAt(0) - '0') + (s.charAt(1) - '0'));
            }
        } else if (n == 3) {
            if (s.charAt(1) != 0) {
                res.add((s.charAt(0) - '0') + Integer.parseInt(s.substring(1)));
            }
            if (s.charAt(2) != 0) {
                res.add(Integer.parseInt(s.substring(0, 2)) + (s.charAt(2) - '0'));
            }
            if (s.charAt(1) != 0 && s.charAt(2) != 0) {
                res.add((s.charAt(0) - '0') + (s.charAt(1) - '0') + (s.charAt(2) - '0'));
            }
        }
        return res;
    }
}