import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long[] getDistances(int[] arr) {
        long[] res = new long[arr.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        for (Integer integer : map.keySet()) {
            List<Integer> index = map.get(integer);
            long[] sums = getSumAbsoluteDifferences(index);
            for (int i = 0; i < index.size(); i++) {
                int index1 = index.get(i);
                res[index1] = sums[i];
            }
        }
        return res;
    }

    public long[] getSumAbsoluteDifferences(List<Integer> nums) {
        int n = nums.size();
        long[] res = new long[n];
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums.get(i);
        }
        for (int i = 0; i < n; ++i) {
            res[i] = (long) i * nums.get(i) - prefixSum[i] + (prefixSum[n] - prefixSum[i] - (long) (n - i) * nums.get(i));
        }
        return res;
    }
}
