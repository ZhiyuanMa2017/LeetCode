import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> l = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int value = nums.get(i).get(j);
                l.add(new int[]{value, i, j});
            }
        }

        Collections.sort(l, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diagonal1 = o1[1] + o1[2];
                int diagonal2 = o2[1] + o2[2];
                if (diagonal1 != diagonal2) {
                    return diagonal1 - diagonal2;
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i)[0];
        }
        return res;
    }
}
