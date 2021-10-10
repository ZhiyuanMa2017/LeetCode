import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[][] count = new int[3][101];
        List<Integer> res = new ArrayList<>();
        for (int n : nums1) {
            count[0][n] = 1;
        }
        for (int n : nums2) {
            count[1][n] = 1;
        }
        for (int n : nums3) {
            count[2][n] = 1;
        }
        for (int i = 1; i < 100; i++) {
            if (count[0][i] + count[1][i] + count[2][i] > 1) {
                res.add(i);
            }
        }
        return res;
    }
}
