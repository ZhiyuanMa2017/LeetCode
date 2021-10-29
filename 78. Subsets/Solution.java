import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int start, List<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(res, nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
