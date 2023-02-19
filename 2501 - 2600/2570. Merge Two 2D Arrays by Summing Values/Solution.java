import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            int id1 = nums1[i][0];
            int id2 = nums2[j][0];
            if (id1 == id2) {
                res.add(new int[]{id1, nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (id1 < id2) {
                res.add(new int[]{id1, nums1[i][1]});
                i++;
            } else {
                res.add(new int[]{id2, nums2[j][1]});
                j++;
            }
        }
        while (i < n) {
            res.add(nums1[i]);
            i++;
        }
        while (j < m) {
            res.add(nums2[j]);
            j++;
        }
        int[][] nums = new int[res.size()][2];
        for (int i1 = 0; i1 < res.size(); i1++) {
            nums[i1] = res.get(i1);
        }
        return nums;
    }
}
