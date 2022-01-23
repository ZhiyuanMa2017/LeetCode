import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution2 {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] != nums[i + 1] && nums[i] != nums[i + 1] - 1) {
                res.add(nums[i]);
            }
            if (i > 0 && i < nums.length - 1
                    && nums[i] != nums[i - 1] && nums[i] != nums[i + 1]
                    && nums[i] != nums[i - 1] + 1 && nums[i] != nums[i + 1] - 1) {
                res.add(nums[i]);
            }
            if (i == nums.length - 1 && nums[i] != nums[i - 1] && nums[i] != nums[i - 1] + 1) {
                res.add(nums[i]);
            }
        }
        return res;
    }
}
