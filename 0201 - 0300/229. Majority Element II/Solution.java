import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Integer one = null;
        Integer two = null;
        int countOne = 0;
        int countTwo = 0;
        for (int i = 0; i < nums.length; i++) {
            if (one != null && one == nums[i]) {
                countOne++;
            } else if (two != null && two == nums[i]) {
                countTwo++;
            } else if (countOne == 0) {
                one = nums[i];
                countOne++;
            } else if (countTwo == 0) {
                two = nums[i];
                countTwo++;
            } else {
                countOne--;
                countTwo--;
            }
        }
        countOne = 0;
        countTwo = 0;
        for (int num : nums) {
            if (one != null && num == one) {
                countOne++;
            }
            if (two != null && num == two) {
                countTwo++;
            }
        }
        if (countOne > nums.length / 3) {
            res.add(one);
        }
        if (countTwo > nums.length / 3) {
            res.add(two);
        }
        return res;
    }
}
