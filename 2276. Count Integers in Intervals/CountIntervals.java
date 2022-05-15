import java.util.TreeMap;

class CountIntervals {
    TreeMap<Integer, Integer> treeMap;
    int size;

    public CountIntervals() {
        treeMap = new TreeMap<>();
        size = 0;
    }

    public void add(int left, int right) {
        if (treeMap.floorKey(right) == null || treeMap.get(treeMap.floorKey(right)) < left) {
            treeMap.put(left, right);
            size += right - left + 1;
        } else {
            int key = left;
            int val = right;
            while (true) {
                int curKey = treeMap.floorKey(val);
                int curVal = treeMap.get(curKey);
                key = Math.min(key, curKey);
                val = Math.max(val, curVal);
                size -= (curVal - curKey + 1);
                treeMap.remove(curKey);
                if (treeMap.floorKey(val) == null || treeMap.get(treeMap.floorKey(val)) < key) {
                    break;
                }
            }
            treeMap.put(key, val);
            size += val - key + 1;
        }
    }

    public int count() {
        return size;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */
