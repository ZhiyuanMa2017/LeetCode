import java.util.TreeMap;

class Solution {
    public int[] amountPainted(int[][] paint) {
        int n = paint.length;
        int[] res = new int[n];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int start = paint[i][0];
            int end = paint[i][1];
            int todo = end - start;
            Integer prev = treeMap.floorKey(start);
            if (prev != null) {
                int prevEnd = treeMap.get(prev);
                if (prevEnd >= end) {
                    continue;
                } else if (prevEnd >= start) {
                    todo -= prevEnd - start;
                    start = prev;
                    treeMap.remove(prev);
                }
            }
            Integer next = treeMap.ceilingKey(start);
            while (next != null && next <= end) {
                if (treeMap.get(next) <= end) {
                    todo -= treeMap.get(next) - next;
                } else {
                    todo -= end - next;
                    end = treeMap.get(next);
                }
                treeMap.remove(next);
                next = treeMap.ceilingKey(next);
            }
            res[i] = todo;
            treeMap.put(start, end);
        }
        return res;
    }
}
