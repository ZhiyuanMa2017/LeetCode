import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        List<int[]> all = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> num = nums.get(i);
            for (Integer cur : num) {
                all.add(new int[]{cur, i});
            }
        }
        Collections.sort(all, (a, b) -> a[0] - b[0]);
        int min = all.get(0)[0];
        int max = all.get(all.size() - 1)[0];
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int total = 0;
        for (int right = 0; right < all.size(); right++) {
            int[] cur = all.get(right);
            int num = cur[0];
            int index = cur[1];
            if (!map.containsKey(index)) {
                map.put(index, 1);
                total++;
            } else {
                map.put(index, map.get(index) + 1);
            }
            if (total == n) {
                while (map.get(all.get(left)[1]) > 1) {
                    map.put(all.get(left)[1], map.get(all.get(left)[1]) - 1);
                    left++;
                }
                int leftNum = all.get(left)[0];
                if (num - leftNum < max - min) {
                    max = num;
                    min = leftNum;
                }
            }
        }
        return new int[]{min, max};
    }
}
