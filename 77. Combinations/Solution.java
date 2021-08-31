import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1, new ArrayList<>());
        return res;
    }

    private void backtracking(int n, int k, int start, List<Integer> soFar) {
        if (k == 0) {
            res.add(new ArrayList<>(soFar));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            soFar.add(i);
            backtracking(n, k - 1, i + 1, soFar);
            soFar.remove(soFar.size() - 1);
        }
    }
}
