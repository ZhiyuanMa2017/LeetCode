import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res;
    List<String> path;
    String S;

    public List<String> restoreIpAddresses(String s) {
        S = s;
        res = new ArrayList<>();
        path = new ArrayList<>();
        backtrack(0, 4);
        return res;
    }

    private void backtrack(int start, int left) {
        if (start == S.length()) {
            if (left == 0) {
                res.add(String.join(".", path));
            }
            return;
        }
        for (int i = start; i < start + 3; i++) {
            if (i >= S.length()) {
                break;
            }
            if (left * 3 < S.length() - i) {
                continue;
            }
            String cur = S.substring(start, i + 1);
            if (isValid(cur)) {
                path.add(cur);
                backtrack(i + 1, left - 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(String cur) {
        if (cur.length() > 3) {
            return false;
        }
        return cur.charAt(0) == '0' ? cur.length() == 1 : Integer.parseInt(cur) <= 255;
    }
}
