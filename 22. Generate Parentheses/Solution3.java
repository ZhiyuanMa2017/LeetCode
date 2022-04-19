import java.util.ArrayList;
import java.util.List;

class Solution3 {
    List<String> res;
    int total;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        total = n;
        dfs(0, 0, "");
        return res;
    }

    private void dfs(int left, int right, String s) {
        if (left == total && right == total) {
            res.add(s);
        }
        if (left < total) {
            dfs(left + 1, right, s + '(');
        }
        if (right < left) {
            dfs(left, right + 1, s + ')');
        }
    }
}
