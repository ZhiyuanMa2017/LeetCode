import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        for (int num : nums1) {
            count[num]++;
        }
        List<Integer> l = new ArrayList<>();
        for (int num : nums2) {
            if (count[num] > 0) {
                l.add(num);
                count[num] = 0;
            }
        }
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        return res;
    }
}
