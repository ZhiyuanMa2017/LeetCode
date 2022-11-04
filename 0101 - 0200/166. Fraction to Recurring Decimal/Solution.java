import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator;
        long b = denominator;
        if (a % b == 0) {
            return String.valueOf(a / b);
        }
        StringBuilder sb = new StringBuilder();
        if (a * b < 0) {
            sb.append("-");
        }
        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a / b);
        sb.append(".");
        a %= b;
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            if (map.containsKey(a)) {
                int index = map.get(a);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            map.put(a, sb.length());
            a *= 10;
            sb.append(a / b);
            a %= b;
        }
        return sb.toString();
    }
}
