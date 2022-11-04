import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", n, n, res);
        return res;
    }

    private void dfs(String cur, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(cur);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(cur + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs(cur + ")", left, right - 1, res);

        }
    }
}
