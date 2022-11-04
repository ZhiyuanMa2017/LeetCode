import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];
            heights.add(new int[]{left, -height});
            heights.add(new int[]{right, height});
        }
        Collections.sort(heights, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Map<Integer, Integer> deleted = new HashMap<>();
        int prev = 0;
        pq.offer(0);
        for (int[] height : heights) {
            int point = height[0];
            int h = height[1];
            if (h < 0) {
                pq.offer(-h);
            } else {
                deleted.put(h, deleted.getOrDefault(h, 0) + 1);
            }
            while (!pq.isEmpty() && deleted.containsKey(pq.peek())) {
                if (deleted.get(pq.peek()) == 1) {
                    deleted.remove(pq.peek());
                } else {
                    deleted.put(pq.peek(), deleted.get(pq.peek()) - 1);
                }
                pq.poll();
            }
            int cur = pq.peek();
            if (cur != prev) {
                List<Integer> tmp = new ArrayList<>(Arrays.asList(point, cur));
                res.add(tmp);
                prev = cur;
            }
        }
        return res;
    }
}
