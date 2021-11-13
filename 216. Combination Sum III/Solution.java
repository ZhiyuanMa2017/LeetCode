import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res;
    int kk;
    int nn;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        kk = k;
        nn = n;
        backtrack(new ArrayList<>(), 1, 0);
        return res;
    }

    private void backtrack(List<Integer> path, int start, int sum) {
        if (path.size() == kk) {
            if (sum == nn) {
                res.add(new ArrayList<>(path));
            }
        }
        if ((sum + (kk - path.size()) * 9) < nn) {
            return;
        }
        if (sum > nn) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            backtrack(path, i + 1, sum + i);
            path.remove(path.size() - 1);
        }
    }
}
