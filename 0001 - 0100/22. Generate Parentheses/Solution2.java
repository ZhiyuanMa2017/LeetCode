import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        backtracking(stringBuilder, n, n, res);
        return res;
    }

    private void backtracking(StringBuilder sb, int left, int right, List<String> res) {
        if (left == 0 & right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            sb.append("(");
            backtracking(sb, left - 1, right, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > 0) {
            sb.append(")");
            backtracking(sb, left, right - 1, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
