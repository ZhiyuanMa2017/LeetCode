import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> res;
    int max;

    public int countMaxOrSubsets(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = max | nums[i];
        }
        res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<Integer>());
        return res.size();
    }

    private void backtrack(int i, int[] nums, ArrayList<Integer> tmp) {
        if (tmp.size() > 0) {
            int temp = tmp.get(0);
            for (int j = 0; j < tmp.size(); j++) {
                temp = temp | tmp.get(j);
            }
            if (temp == max) {
                res.add(new ArrayList<>(tmp));
            }
        }

        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
