import java.util.TreeMap;

class MyCalendarThree {
    TreeMap<Integer, Integer> treeMap;

    public MyCalendarThree() {
        treeMap = new TreeMap<>();
    }

    public int book(int start, int end) {
        treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
        treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);
        int res = 0;
        int cur = 0;
        for (Integer key : treeMap.keySet()) {
            cur += treeMap.get(key);
            res = Math.max(res, cur);
        }
        return res;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
