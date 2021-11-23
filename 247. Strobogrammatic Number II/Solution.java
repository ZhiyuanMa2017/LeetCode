import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Character, Character> map;
    List<String> res;

    public List<String> findStrobogrammatic(int n) {
        map = new HashMap<>() {{
            put('0', '0');
            put('1', '1');
            put('6', '9');
            put('8', '8');
            put('9', '6');
        }};
        res = new ArrayList<>();
        char[] num = new char[n];
        backtrack(0, num);
        return res;
    }

    private void backtrack(int start, char[] num) {
        if (start >= (num.length + 1) / 2) {
            res.add(new String(num));
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
}
