import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> s = new ArrayDeque<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int cur = s.pop();
                int plus = cur + s.peek();
                s.push(cur);
                s.push(plus);
            } else if (op.equals("C")) {
                s.pop();
            } else if (op.equals("D")) {
                s.push(s.peek() * 2);
            } else {
                s.push(Integer.parseInt(op));
            }
        }
        int res = 0;
        while (!s.isEmpty()) {
            res += s.pop();
        }
        return res;
    }
}
