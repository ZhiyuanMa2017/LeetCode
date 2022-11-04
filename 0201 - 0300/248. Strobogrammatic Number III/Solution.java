import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Character, Character> map;
    int res;
    String l;
    String h;

    public int strobogrammaticInRange(String low, String high) {
        map = new HashMap<>() {{
            put('0', '0');
            put('1', '1');
            put('6', '9');
            put('8', '8');
            put('9', '6');
        }};
        res = 0;
        l = low;
        h = high;
        for (int i = low.length(); i <= high.length(); i++) {
            char[] num = new char[i];
            backtrack(0, num);
        }
        return res;
    }

    private void backtrack(int start, char[] num) {
        if (start >= (num.length + 1) / 2) {
            String s = new String(num);
            if ((s.length() == l.length() && s.compareTo(l) < 0) || (s.length() == h.length() && s.compareTo(h) > 0)) {
                return;
            }
            res++;
        } else {
            for (Character c : map.keySet()) {
                if (start == 0 && num.length > 1 && c == '0') {
                    continue;
                }
                if (start == num.length / 2 && (c == '6' || c == '9')) {
                    continue;
                }
                num[start] = c;
                num[num.length - 1 - start] = map.get(c);
                backtrack(start + 1, num);
            }
        }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.strobogrammaticInRange("0", "0"));

    }
}
