import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i : set1) {
            if (!set2.contains(i)) {
                l1.add(i);
            }
        }
        for (int i : set2) {
            if (!set1.contains(i)) {
                l2.add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(l1);
        res.add(l2);
        return res;
    }
}
