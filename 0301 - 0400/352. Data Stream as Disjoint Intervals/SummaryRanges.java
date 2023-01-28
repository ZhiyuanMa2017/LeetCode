import java.util.TreeMap;

class SummaryRanges {
    TreeMap<Integer, Integer> treeMap;

    public SummaryRanges() {
        treeMap = new TreeMap<>();
        treeMap.put(-2, -2);
        treeMap.put(10002, 10002);
    }

    public void addNum(int value) {
        int s1 = treeMap.floorKey(value);
        int s2 = treeMap.ceilingKey(value);
        int e1 = treeMap.get(s1);
        int e2 = treeMap.get(s2);
        if (e1 >= value) {
            return;
        } else if (e1 + 1 == value && value + 1 == s2) {
            treeMap.remove(s1);
            treeMap.remove(s2);
            treeMap.put(s1, e2);
        } else if (e1 + 1 == value) {
            treeMap.put(s1, value);
        } else if (value + 1 == s2) {
            treeMap.remove(s2);
            treeMap.put(value, e2);
        } else {
            treeMap.put(value, value);
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[treeMap.size() - 2][2];
        int i = 0;
        for (Integer key : treeMap.keySet()) {
            if (key >= 0 && key <= 10000) {
                res[i] = new int[]{key, treeMap.get(key)};
                i++;
            }
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
