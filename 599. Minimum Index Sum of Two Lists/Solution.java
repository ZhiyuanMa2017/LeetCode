import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int index = map.get(list2[i]);
                if (index + i < min) {
                    min = index + i;
                    res = new ArrayList<>();
                    res.add(list2[i]);
                } else if (index + i == min) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[]{});
    }
}
