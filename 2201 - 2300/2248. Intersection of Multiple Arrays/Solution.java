import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] bucket = new int[1001];
        for (int[] num : nums) {
            for (int j = 0; j < num.length; j++) {
                bucket[num[j]]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            if (bucket[i] >= nums.length) {
                res.add(i);
            }
        }
        return res;
    }
}
