import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                track.add(nums[i]);
                backtrack(nums, track, used);
                track.remove(track.size() - 1);
                used[i] = false;
            }
        }
    }
}
