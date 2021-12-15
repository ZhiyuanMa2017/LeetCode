import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canWin(String currentState) {
        if (currentState.length() < 2) {
            return false;
        }
        Map<String, Boolean> map = new HashMap<>();
        return backtrack(currentState.toCharArray(), map);
    }

    private boolean backtrack(char[] chars, Map<String, Boolean> map) {
        String s = new String(chars);
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '+' && chars[i + 1] == '+') {
                chars[i] = '-';
                chars[i + 1] = '-';
                boolean res = backtrack(chars, map);
                chars[i] = '+';
                chars[i + 1] = '+';
                if (!res) {
                    map.put(s, true);
                    return true;
                }

            }
        }
        map.put(s, false);
        return false;
    }
}
