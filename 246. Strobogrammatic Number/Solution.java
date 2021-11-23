import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>() {{
            put('1', '1');
            put('0', '0');
            put('8', '8');
            put('6', '9');
            put('9', '6');
        }};
        int n = num.length();
        for (int i = 0; i < (n + 1) / 2; i++) {
            int j = n - 1 - i;
            Character l = num.charAt(i);
            Character r = num.charAt(j);
            if (!map.containsKey(l) || !map.containsKey(r)) {
                return false;
            }
            if (map.get(l) != r) {
                return false;
            }
        }
        return true;
    }
}
