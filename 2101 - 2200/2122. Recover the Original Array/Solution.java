import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Integer, Integer> map;

    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);

        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 1; i < nums.length; i++) {
            int k = nums[i] - nums[0];
            if (k == 0 || k % 2 != 0) {
                continue;
            }
            k = k / 2;
            int[] res = helper(nums, k);
            if (res != null) {
                return res;
            }
        }
        return null;
    }

    private int[] helper(int[] nums, int k) {
        Map<Integer, Integer> thisMap = new HashMap<>(map);
        List<Integer> l = new ArrayList<>();
        for (int num : nums) {
            if (!thisMap.containsKey(num)) {
                continue;
            }
            int bigger = num + 2 * k;
            if (!thisMap.containsKey(bigger)) {
                return null;
            }
            l.add(num + k);
            thisMap.put(num, thisMap.get(num) - 1);
            if (thisMap.get(num) == 0) {
                thisMap.remove(num);
            }

            thisMap.put(bigger, thisMap.get(bigger) - 1);
            if (thisMap.get(bigger) == 0) {
                thisMap.remove(bigger);
            }
            if (l.size() == nums.length / 2) {
                int[] res = new int[l.size()];
                for (int i = 0; i < l.size(); i++) {
                    res[i] = l.get(i);
                }
                return res;
            }
        }
        return null;
    }
}
