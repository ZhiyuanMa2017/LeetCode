import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        TreeMap<Long, long[]> treeMap = new TreeMap<>();
        treeMap.put(0L, new long[2]);
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            treeMap.put((long) nums[i], new long[]{i + 1, sum});
        }
        List<Long> res = new ArrayList<>();
        for (long query : queries) {
            long[] values = treeMap.floorEntry(query).getValue();
            long count = values[0];
            long curPreSum = values[1];
            long cur = 0;
            cur += count * query - curPreSum;
            cur += sum - curPreSum - (n - count) * query;
            res.add(cur);
        }
        return res;
    }
}
