import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> getFactors(int n) {
        res = new ArrayList<>();
        backtrack(n, new ArrayList<>(), 2);
        return res;
    }

    private void backtrack(int n, List<Integer> path, int last) {
        for (int i = last; i * i <= n; i++) {
            if (n % i == 0) {
                path.add(i);
                path.add(n / i);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                backtrack(n / i, path, i);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.getFactors(12);
    }
}
