import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;
        Map<String, Long> cToCount = new HashMap<>();
        Map<String, Integer> cToMaxID = new HashMap<>();
        long max = 0;
        for (int i = 0; i < n; i++) {
            String c = creators[i];
            String id = ids[i];
            int v = views[i];
            if (!cToCount.containsKey(c)) {
                cToCount.put(c, (long) v);
                cToMaxID.put(c, i);
            } else {
                cToCount.put(c, cToCount.get(c) + v);
                int prevId = cToMaxID.get(c);
                if (views[i] > views[prevId] || views[i] == views[prevId] && id.compareTo(ids[prevId]) < 0) {
                    cToMaxID.put(c, i);
                }
            }
            max = Math.max(max, cToCount.get(c));
        }
        List<List<String>> res = new ArrayList<>();
        for (String s : cToCount.keySet()) {
            if (cToCount.get(s) == max) {
                res.add(List.of(s, ids[cToMaxID.get(s)]));
            }
        }
        return res;
    }
}
