import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int countLess = 0;
        int countEqual = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                countEqual++;
            }
            if (nums[i] < target) {
                countLess++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < countEqual; i++) {
            res.add(countLess);
            countLess++;
        }
        return res;
    }
}
