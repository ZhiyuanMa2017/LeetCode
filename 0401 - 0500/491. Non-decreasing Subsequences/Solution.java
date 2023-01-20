import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> path) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < n; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            if (path.size() == 0 || nums[i] >= path.get(path.size() - 1)) {
                set.add(nums[i]);
                path.add(nums[i]);
                dfs(nums, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
