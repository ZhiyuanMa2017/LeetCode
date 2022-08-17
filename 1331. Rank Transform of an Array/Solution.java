import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] nums = Arrays.copyOf(arr, arr.length);
        Arrays.sort(nums);
        Map<Integer, Integer> valToRank = new HashMap<>();
        for (int num : nums) {
            if (!valToRank.containsKey(num)) {
                valToRank.put(num, valToRank.size() + 1);
            }
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = valToRank.get(arr[i]);
        }
        return res;
    }
}
