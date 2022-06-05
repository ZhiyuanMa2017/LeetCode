import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valueToIndex.put(nums[i], i);
        }
        for (int[] operation : operations) {
            int before = operation[0];
            int after = operation[1];
            int index = valueToIndex.get(before);
            nums[index] = after;
            valueToIndex.remove(before);
            valueToIndex.put(after, index);
        }
        return nums;
    }
}
