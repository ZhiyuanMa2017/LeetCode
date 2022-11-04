import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Node>> map = new HashMap<>();
        int n = username.length;
        for (int i = 0; i < n; i++) {
            String name = username[i];
            int time = timestamp[i];
            String web = website[i];
            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).add(new Node(time, web));
        }
        Map<String, Integer> count = new HashMap<>();
        int res = 0;
        String pattern = "";
        for (String name : map.keySet()) {
            Set<String> visited = new HashSet<>();
            List<Node> l = map.get(name);
            l.sort(Comparator.comparingInt(a -> a.time));
            int len = l.size();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    for (int k = j + 1; k < len; k++) {
                        String three = l.get(i).web + " " + l.get(j).web + " " + l.get(k).web;
                        if (!visited.contains(three)) {
                            count.put(three, count.getOrDefault(three, 0) + 1);
                            if (res == 0) {
                                res = count.get(three);
                                pattern = three;
                            } else {
                                if (count.get(three) > res) {
                                    res = count.get(three);
                                    pattern = three;
                                } else if (count.get(three) == res) {
                                    if (three.compareTo(pattern) < 0) {
                                        pattern = three;
                                    }
                                }
                            }
                            visited.add(three);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(Arrays.asList(pattern.split(" ")));

    }


    class Node {
        int time;
        String web;

        Node(int i, String s) {
            time = i;
            web = s;
        }
    }
}
