import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution2 {
    Set<String> set = new HashSet<>();
    int maxCount;

    public List<String> removeInvalidParentheses(String s) {
        int leftMisplaced = 0;
        int rightMisplaced = 0;
        int lCount = 0;
        int rightCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMisplaced++;
                lCount++;
            } else if (c == ')') {
                rightCount++;
                if (leftMisplaced > 0) {
                    leftMisplaced--;
                } else {
                    rightMisplaced++;
                }
            }
        }

        maxCount = Math.min(lCount, rightCount);
        dfs(s, 0, 0, leftMisplaced, rightMisplaced, "");
        return new ArrayList<>(set);
    }

    private void dfs(String s, int index, int score, int leftMisplaced, int rightMisplaced, String cur) {
        if (score < 0 || score > maxCount || leftMisplaced < 0 || rightMisplaced < 0) {
            return;
        }
        if (index == s.length()) {
            if (leftMisplaced == 0 && rightMisplaced == 0) {
                set.add(cur);
            }
        } else {
            char c = s.charAt(index);
            if (c == '(') {
                dfs(s, index + 1, score + 1, leftMisplaced, rightMisplaced, cur + c);
                dfs(s, index + 1, score, leftMisplaced - 1, rightMisplaced, cur);
            } else if (c == ')') {
                dfs(s, index + 1, score - 1, leftMisplaced, rightMisplaced, cur + c);
                dfs(s, index + 1, score, leftMisplaced, rightMisplaced - 1, cur);
            } else {
                dfs(s, index + 1, score, leftMisplaced, rightMisplaced, cur + c);
            }
        }
    }
}
