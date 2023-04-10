import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            }
            map.get(num).add(i);
        }
        long[] res = new long[n];
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            long left = 0;
            for (int i = 1; i < list.size(); i++) {
                left += (long) (list.get(i) - list.get(i - 1)) * i;
                res[list.get(i)] += left;
            }
            long right = 0;
            for (int i = list.size() - 2; i >= 0; i--) {
                right += (long) (list.get(i + 1) - list.get(i)) * (list.size() - 1 - i);
                res[list.get(i)] += right;
            }
        }
        return res;
    }
}
