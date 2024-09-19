import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> parent = new HashMap<>();
        for (List<String> region : regions) {
            for (int i = 1; i < region.size(); i++) {
                parent.put(region.get(i), region.get(0));
            }
        }
        Set<String> path = new HashSet<>();
        while (region1 != null) {
            path.add(region1);
            region1 = parent.get(region1);
        }
        while (!path.contains(region2)) {
            region2 = parent.get(region2);
        }
        return region2;
    }
}
