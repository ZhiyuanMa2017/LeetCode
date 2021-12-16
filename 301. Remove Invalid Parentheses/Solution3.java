import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution3 {
    Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int leftMisplaced = 0;
        int rightMisplaced = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftMisplaced++;
            } else if (s.charAt(i) == ')') {
                if (leftMisplaced > 0) {
                    leftMisplaced--;
                } else {
                    rightMisplaced++;
                }
            }
        }
        backtrack(s, 0, 0, 0, leftMisplaced, rightMisplaced, new StringBuilder());
        return new ArrayList<>(set);
    }

    private void backtrack(String s, int index, int leftCount, int rightCount, int leftMisplaced, int rightMisplaced, StringBuilder sb) {
        if (leftMisplaced < 0 || rightMisplaced < 0 || leftCount - rightCount < 0) {
            return;
        }
        if (index == s.length()) {
            if (leftMisplaced == 0 && rightMisplaced == 0) {
                set.add(sb.toString());
            }
        } else {
            char c = s.charAt(index);
            // not use
            if ((c == '(' && leftMisplaced > 0) || (c == ')' && rightMisplaced > 0)) {
                backtrack(s, index + 1, leftCount, rightCount, leftMisplaced + (c == '(' ? -1 : 0), rightMisplaced + (c == ')' ? -1 : 0), sb);
            }
            sb.append(c);
            if (c != '(' && c != ')') {
                backtrack(s, index + 1, leftCount, rightCount, leftMisplaced, rightMisplaced, sb);
            } else {
                if (c == '(') {
                    backtrack(s, index + 1, leftCount + 1, rightCount, leftMisplaced, rightMisplaced, sb);
                } else {
                    if (rightCount < leftCount) {
                        backtrack(s, index + 1, leftCount, rightCount + 1, leftMisplaced, rightMisplaced, sb);
                    }
                }
            }
            sb.setLength(sb.length() - 1);
        }
    }
}
