import java.util.TreeMap;

class MyCalendarThree {
    TreeMap<Integer, Integer> treeMap;
    int res;

    public MyCalendarThree() {
        treeMap = new TreeMap<>();
        treeMap.put(-1, 0);
        res = 0;
    }

    public int book(int start, int end) {
        treeMap.put(start, treeMap.get(treeMap.floorKey(start)));
        treeMap.put(end, treeMap.get(treeMap.floorKey(end)));
        for (Integer key : treeMap.subMap(start, end).keySet()) {
            int val = treeMap.get(key);
            treeMap.put(key, val + 1);
            res = Math.max(res, val + 1);
        }
        return res;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
