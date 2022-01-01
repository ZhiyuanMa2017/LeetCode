import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        Comparator<String> c = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                if (count.get(s1).equals(count.get(s2))) {
                    return s2.compareTo(s1);
                }
                return count.get(s1) - count.get(s2);
            }
        };

        PriorityQueue<String> minHeap = new PriorityQueue<>(c);
        for (String w : count.keySet()) {
            minHeap.offer(w);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
