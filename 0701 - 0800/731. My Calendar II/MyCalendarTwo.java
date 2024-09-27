import java.util.Map;
import java.util.TreeMap;

class MyCalendarTwo {
    TreeMap<Integer, Integer> treeMap;

    public MyCalendarTwo() {
        treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
        treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);
        int cur = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            cur += entry.getValue();
            if (cur > 2) {
                treeMap.put(start, treeMap.get(start) - 1);
                if (treeMap.get(start) == 0) {
                    treeMap.remove(start);
                }
                treeMap.put(end, treeMap.get(end) + 1);
                if (treeMap.get(end) == 0) {
                    treeMap.remove(end);
                }
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
