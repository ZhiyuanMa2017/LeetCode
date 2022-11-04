import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            list.add(new int[]{i, heights[i]});
        }
        Collections.sort(list, (a, b) -> b[1] - a[1]);
        String[] res = new String[names.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = names[list.get(i)[0]];
        }
        return res;
    }
}
