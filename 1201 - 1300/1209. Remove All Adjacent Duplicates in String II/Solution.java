import java.util.Stack;

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> pairs = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!pairs.isEmpty() && pairs.peek().c == c) {
                pairs.peek().count++;
            } else {
                pairs.add(new Pair(c, 1));
            }
            if (pairs.peek().count == k) {
                pairs.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Pair p : pairs) {
            for (int i = 0; i < p.count; i++) {
                sb.append(p.c);
            }
        }
        return sb.toString();
    }

    class Pair {
        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
