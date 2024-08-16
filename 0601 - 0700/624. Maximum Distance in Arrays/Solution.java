import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int m = arrays.size();
        List<Integer> list0 = arrays.get(0);
        int min = list0.get(0);
        int max = list0.get(list0.size() - 1);
        int res = 0;
        for (int i = 1; i < m; i++) {
            int curMin = arrays.get(i).get(0);
            int curMax = arrays.get(i).get(arrays.get(i).size() - 1);
            res = Math.max(res, max - curMin);
            res = Math.max(res, curMax - min);
            min = Math.min(min, curMin);
            max = Math.max(max, curMax);
        }
        return res;
    }
}
