import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtracking(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    private void backtracking(int[] candidates, int target, int sum, int start, List<Integer> combination) {
        if (sum == target) {
            res.add(new ArrayList<>(combination));
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], i, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
