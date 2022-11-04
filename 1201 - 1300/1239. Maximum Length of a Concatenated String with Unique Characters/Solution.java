import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxLength(List<String> arr) {
        List<String> l = new ArrayList<>();
        l.add("");
        for (String s : arr) {
            if (!isUnique(s)) {
                continue;
            }
            List<String> list = new ArrayList<>();
            for (String s1 : l) {
                String temp = s1 + s;
                if (isUnique(temp)) {
                    list.add(temp);
                }
            }
            l.addAll(list);
        }
        int res = 0;
        for (String s : l) {
            res = Math.max(s.length(), res);
        }
        return res;
    }

    private boolean isUnique(String s) {
        if (s.length() > 26) {
            return false;
        }
        boolean[] alphabet = new boolean[26];
        for (char c : s.toCharArray()) {
            if (alphabet[c - 'a']) {
                return false;
            } else {
                alphabet[c - 'a'] = true;
            }
        }
        return true;
    }
}
