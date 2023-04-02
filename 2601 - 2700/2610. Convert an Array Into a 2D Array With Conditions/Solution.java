import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[210];
        int max = 0;
        for (int num : nums) {
            freq[num]++;
            max = Math.max(max, freq[num]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < freq[i]; j++) {
                res.get(j).add(i);
            }
        }
        return res;
    }
}
