import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                for (int j = i - k; j <= i + k; j++) {
                    if (j >= 0 && j < nums.length) {
                        set.add(j);
                    }
                }
            }
        }
        List<Integer> l = new ArrayList<>(set);
        Collections.sort(l);
        return l;
    }
}
