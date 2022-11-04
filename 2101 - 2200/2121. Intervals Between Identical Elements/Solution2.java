import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {
    public long[] getDistances(int[] arr) {
        long[] res = new long[arr.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            long sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            long preSum = 0;
            for (int i = 0; i < list.size(); i++) {
                int num = list.get(i);
                preSum += num;
                long leftSum = (long) i * num - (preSum - num);
                long rightSum = sum - preSum - (long) (list.size() - i - 1) * num;
                res[num] = leftSum + rightSum;
            }
        }
        return res;
    }
}
