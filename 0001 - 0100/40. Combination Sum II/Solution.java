import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int sum, List<Integer> combination, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(combination));
        } else if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], combination, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
