import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();
        for (String timePoint : timePoints) {
            list.add(convert(timePoint));
        }
        Collections.sort(list);
        int res = 24 * 60 + list.get(0) - list.get(list.size() - 1);
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res, list.get(i) - list.get(i - 1));
        }
        return res;
    }

    private int convert(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3));
        return hour * 60 + min;
    }
}
