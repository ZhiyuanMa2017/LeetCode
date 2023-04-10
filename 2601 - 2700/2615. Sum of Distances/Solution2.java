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
        // LeetCode 1685
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            long rSum = 0;
            for (Integer integer : list) {
                rSum += integer;
            }
            long lSum = 0;
            for (int i = 0; i < list.size(); i++) {
                rSum -= list.get(i);
                long left = (long) list.get(i) * i - lSum;
                long right = rSum - (long) (list.size() - 1 - i) * list.get(i);
                res[list.get(i)] = left + right;
                lSum += list.get(i);
            }
        }
        return res;
    }
}
