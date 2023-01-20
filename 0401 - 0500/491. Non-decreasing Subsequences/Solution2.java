import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            if (path.size() >= 2) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (path.size() == 0 || nums[index] >= path.get(path.size() - 1)) {
            path.add(nums[index]);
            dfs(nums, index + 1, path);
            path.remove(path.size() - 1);
        }
        if (path.size() == 0 || nums[index] != path.get(path.size() - 1)) {
            dfs(nums, index + 1, path);
        }
    }
}
