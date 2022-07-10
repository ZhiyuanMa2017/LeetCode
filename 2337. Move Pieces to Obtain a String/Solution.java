import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canChange(String start, String target) {
        List<Node> s = new ArrayList<>();
        List<Node> t = new ArrayList<>();
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                s.add(new Node('L', i));
            } else if (start.charAt(i) == 'R') {
                s.add(new Node('R', i));
            }
        }
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == 'L') {
                t.add(new Node('L', i));
            } else if (target.charAt(i) == 'R') {
                t.add(new Node('R', i));
            }
        }
        if (s.size() != t.size()) {
            return false;
        }
        for (int i = 0; i < s.size(); i++) {
            Node n1 = s.get(i);
            Node n2 = t.get(i);
            if (n1.c != n2.c) {
                return false;
            }
            if (n1.c == 'L') {
                if (n2.index > n1.index) {
                    return false;
                }
            }
            if (n1.c == 'R') {
                if (n1.index > n2.index) {
                    return false;
                }
            }
        }
        return true;
    }

    class Node {
        char c;
        int index;

        Node(char c, int i) {
            this.c = c;
            index = i;
        }

    }
}
