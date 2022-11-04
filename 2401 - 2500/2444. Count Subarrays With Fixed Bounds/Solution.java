import java.util.ArrayList;
import java.util.List;

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        if (minK == maxK) {
            return getSame(nums, minK);
        }
        int n = nums.length;
        boolean max = false;
        boolean min = false;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int num : nums) {
            if (num > maxK || num < minK) {
                if (max && min) {
                    list.add(cur);
                }
                cur = new ArrayList<>();
                max = false;
                min = false;
            } else {
                cur.add(num);
                if (num == minK) {
                    min = true;
                } else if (num == maxK) {
                    max = true;
                }
            }
        }
        if (max && min) {
            list.add(cur);
        }
        int res = 0;
        for (List<Integer> l : list) {
            res += getCount(l, minK, maxK);
        }
        return res;
    }

    private long getSame(int[] nums, int k) {
        int cur = 0;
        long res = 0;
        for (int num : nums) {
            if (num == k) {
                cur++;
                res += cur;
            } else {
                cur = 0;
            }
        }
        return res;
    }

    private long getCount(List<Integer> l, int min, int max) {
        int n = l.size();
        int i = 0;
        int j = 0;
        while (i < n && l.get(i) != min) {
            i++;
        }
        while (j < n && l.get(j) != max) {
            j++;
        }
        int ii = Math.min(i, j);
        int jj = Math.max(i, j);
        long res = (long) (ii + 1) * (n - jj);
        int last = ii;
        while (ii < n && jj < n) {
            int num = l.get(ii);
            ii++;
            while (ii < n && l.get(ii) != num) {
                ii++;
            }
            if (ii < n) {
                int tmp = Math.min(ii, jj);
                jj = Math.max(ii, jj);
                ii = tmp;
                res += (long) (ii - last) * (n - jj);
                last = ii;
            }
        }
        return res;
    }
}
