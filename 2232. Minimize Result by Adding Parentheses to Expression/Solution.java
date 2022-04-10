import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minimizeResult(String expression) {
        int n = expression.length();
        int index = expression.indexOf("+");
        StringBuilder sb;
        Map<Integer, String> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < index; i++) {
            for (int j = index + 2; j <= n; j++) {
                sb = new StringBuilder();
                sb.append(expression.substring(0, i)).append("(").append(expression.substring(i, index));
                sb.append(expression.substring(index, j)).append(")").append(expression.substring(j, n));
                int cur = cal(sb.toString());
                if (min > cur) {
                    min = cur;
                    if (!map.containsKey(cur)) {
                        map.put(cur, sb.toString());
                    }
                }
            }
        }
        return map.get(min);
    }

    public int cal(String s) {
        s = " " + s + " ";
        String[] parts = s.split("\\(");
        String first = parts[0].strip();
        String[] parts2 = parts[1].split("\\)");
        String last = parts2[1].strip();
        String[] plus = parts2[0].split("\\+");
        String one = plus[0].strip();
        String two = plus[1].strip();
        int firstV;
        if (!first.equals("")) {
            firstV = Integer.parseInt(first);
        } else {
            firstV = 1;
        }
        int lastV;
        if (!last.equals("")) {
            lastV = Integer.parseInt(last);
        } else {
            lastV = 1;
        }

        return firstV * (Integer.parseInt(one) + Integer.parseInt(two)) * lastV;
    }
}
